package cn.xxblog.demo.util;

import cn.xxblog.demo.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KeepAliveThread extends Thread {
    public static String message = "type@=keeplive/tick@=%d/\0";

    SocketUtil socketUtil;

    public KeepAliveThread(){
         socketUtil = new SocketUtil();
    }

    @Override
    public void run() {
        log.info("start keep alive thread.");
        try {
            while (true) {
                Thread.sleep(40 * 1000);
                socketUtil.send(new Message(String.format(message, (System.currentTimeMillis() / 1000))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
