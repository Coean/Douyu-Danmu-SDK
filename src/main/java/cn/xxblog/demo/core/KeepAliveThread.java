package cn.xxblog.demo.core;

import cn.xxblog.demo.vo.Constants;
import cn.xxblog.demo.vo.RoomSocket;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *
 * @author Devpan
 */
@Slf4j
public class KeepAliveThread extends Thread {

    static LinkedBlockingQueue<RoomSocket> queue;
    private static Set roomSet;
    private static KeepAliveThread keepAliveThread;

    private KeepAliveThread() {
    }

    public static synchronized KeepAliveThread getInstance() {
        if (keepAliveThread == null) {
            keepAliveThread = new KeepAliveThread();
            queue = new LinkedBlockingQueue<>();
            roomSet = new HashSet();
        }
        return keepAliveThread;
    }

    public void addRoom(RoomSocket roomSocket) {
        if (Objects.isNull(roomSocket)) {
            throw new IllegalArgumentException("roomSocket不能为空");
        }
        roomSocket.validate();
        if (roomSet.contains(roomSocket.getRoomId())) {
            throw new IllegalArgumentException(String.format("Room: %d already added into keep alive queue.", roomSocket.getRoomId()));
        }
        if (!queue.offer(roomSocket)) {
            throw new RuntimeException(String.format("RoomId: %d 无法添加任务到队列中！", roomSocket.getRoomId()));
        }
        roomSet.add(roomSocket.getRoomId());

        //start thread.
        if (!keepAliveThread.isAlive()) {
            keepAliveThread.start();
        }
    }

    @Override
    public void run() {
        log.info("start keep alive thread.");
        while (true) {
            try {
                //从队列中获取第一个元素
                RoomSocket roomSocket = queue.take();
                //检测下次运行时间
                if (Objects.nonNull(roomSocket.getNextKeepTime()) && System.currentTimeMillis() < roomSocket.getNextKeepTime()) {
                    //等待
                    Thread.sleep(roomSocket.getNextKeepTime() - System.currentTimeMillis());
                }
                //发生保持在线指令
                roomSocket.getSocketUtil().send(Constants.keepAliveMessage());
                //更新下次运行时间
                updateNextKeepAliveTime(roomSocket);
                log.debug("Send keep alive message for Room: {}, next time is: {}", roomSocket.getRoomId(),
                          DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(
                              LocalDateTime.ofInstant(Instant.ofEpochMilli(roomSocket.getNextKeepTime()), TimeZone.getDefault().toZoneId())));
                //重新插入队列
                if (!queue.offer(roomSocket)) {
                    throw new RuntimeException(String.format("RoomId: %d 无法添加任务到队列中！", roomSocket.getRoomId()));
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }

    }

    /**
     * fill next keep alive time.
     */
    private void updateNextKeepAliveTime(RoomSocket roomSocket) {
        roomSocket.setNextKeepTime(System.currentTimeMillis() + Constants.DEFAULT_KEEP_ALIVE_TIME);
    }
}


