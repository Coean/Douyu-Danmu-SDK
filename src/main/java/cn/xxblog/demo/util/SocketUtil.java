package cn.xxblog.demo.util;

import cn.xxblog.demo.Message;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Slf4j
public class SocketUtil {
    public static final String host = "openbarrage.douyutv.com";
    public static final Integer port = 8601;

    static Socket socket;

    public SocketUtil() {
        connect(host, port);
    }


    public boolean connect(String host, Integer port) {
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
            if (connect(host, port)) {

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


    public static void main(String[] args) {
        String login = "type@=loginreq/roomid@=757122/\0";
        String joinGroup = "type@=joingroup/rid@=757122/gid@=-9999/\0";


        SocketUtil socketUtil = new SocketUtil();
        socketUtil.send(new Message(login));
        socketUtil.send(new Message(joinGroup));

        new Thread(new KeepAliveThread()).start();

        new Thread(new RecivedThread(socket)).start();

        log.info("end");
    }
}
