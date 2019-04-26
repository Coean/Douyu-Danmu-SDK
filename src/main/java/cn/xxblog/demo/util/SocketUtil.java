package cn.xxblog.demo.util;

import static cn.xxblog.demo.vo.Constants.DOUYU_HOST;
import static cn.xxblog.demo.vo.Constants.DOUYU_PORT;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import cn.xxblog.demo.vo.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author devpan
 */
@Slf4j
@Data
public class SocketUtil {


    private Socket socket;

    public SocketUtil() {
        connect(DOUYU_HOST, DOUYU_PORT);
    }


    /**
     * create socket connect
     */
    private boolean connect(String host, Integer port) {
        if (socket != null && socket.isConnected()) {
            return true;
        }
        log.info("connect");
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return socket.isConnected();
    }

    public synchronized void send(Message message) {
        log.info("send message:{}", message);
        if (socket == null || !socket.isConnected()) {
            log.info("connection is closed.");
            if (connect(DOUYU_HOST, DOUYU_PORT)) {
                //todo need hance this logic for handle the network issue.
            }
        }
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getMessage().toByteArray());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        String login = "type@=loginreq/roomid@=757122/\0";
//        String joinGroup = "type@=joingroup/rid@=757122/gid@=-9999/\0";
//
//        SocketUtil socketUtil = new SocketUtil();
//        socketUtil.send(new Message(login));
//        socketUtil.send(new Message(joinGroup));
//
//        new KeepAliveThread().start();
//        new ReceivedThread(socket).start();
//
//        log.info("end");
//    }
}
