package cn.xxblog.demo.util;

import static cn.xxblog.demo.vo.Constants.DOUYU_HOST;
import static cn.xxblog.demo.vo.Constants.DOUYU_PORT;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import cn.xxblog.demo.vo.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 */
@Slf4j
@Data
public class SocketUtil {

    private Socket socket;
    private boolean closeFlag = false;

    public SocketUtil() {
        connect(DOUYU_HOST, DOUYU_PORT);
    }

    public SocketUtil(String douyuHost, Integer port) {
        connect(douyuHost, port);
    }

    /**
     * create socket connect
     */
    private boolean connect(String host, Integer port) {
        if (socket != null && socket.isConnected()) {
            return true;
        }
        log.debug("connect");
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return socket.isConnected();
    }

    /**
     * close socket connect
     */
    public void close() {
        try {
            if (socket != null) {
                socket.close();
            }
            closeFlag = false;
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    public synchronized void send(Message message) {
        log.debug("send message:{}", message);
        if (closeFlag) {
            log.debug("connect is closed");
        }
        if (socket == null || !socket.isConnected()) {
            log.info("connection is closed.");
            if (connect(DOUYU_HOST, DOUYU_PORT)) {
                //todo need enhance this logic for handle the network issue.
            }
        }
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getMessage().toByteArray());
            outputStream.flush();
        } catch (SocketException e) {
            reConnect();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    private void reConnect() {
        log.debug("re-connect");
        try {
            socket = new Socket(DOUYU_HOST, DOUYU_PORT);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
