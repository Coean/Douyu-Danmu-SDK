package cn.xxblog.demo;

import java.io.IOException;
import java.net.Socket;

import cn.xxblog.demo.util.ReceivedThread;

public class Test2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("openbarrage.douyutv.com", 8601);

        String loginCMD = "type@=loginreq/roomid@=757122/";
        socket.getOutputStream().write(new Message(loginCMD).getMessage().toByteArray());

        new ReceivedThread(socket).start();

        //加入弹幕分组开始接收弹幕
        String joinGroupCMD = "type@=joingroup/rid@=757122/gid@=-9999/";
        socket.getOutputStream().write(new Message(joinGroupCMD).getMessage().toByteArray());
    }


}
