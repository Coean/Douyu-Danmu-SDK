package cn.xxblog.demo;

import cn.xxblog.demo.core.Core;
import cn.xxblog.demo.core.KeepAliveThread;
import cn.xxblog.demo.core.ReceivedThread;
import cn.xxblog.demo.listener.MsgListener;
import cn.xxblog.demo.util.SocketUtil;
import cn.xxblog.demo.vo.BaseMsg;
import cn.xxblog.demo.vo.Constants;
import cn.xxblog.demo.vo.RoomSocket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DanMuClient {

    private SocketUtil socketUtil;
    private Integer roomId;
    private Core core;

    public DanMuClient(Integer roomId){
        this.socketUtil = new SocketUtil();
        this.roomId = roomId;
        this.core = new Core();
    }

    public void start(){
        if (core.checkListener()) {
            log.warn("have not register the Danmu listener, system will use the default listener to print message to console.");
        }
        //start to receive message
        new ReceivedThread(socketUtil.getSocket()).start();
        //login
        login();
        //join danmu group
        joinDanMuGroup();
        //add socket into keep alive thread
        KeepAliveThread.getInstance().addRoom(RoomSocket.builder().roomId(roomId).socketUtil(socketUtil).build());
    }

    /**
     * send join danmu group message.
     * */
    private void joinDanMuGroup() {
        socketUtil.send(Constants.joinGroupMessage(roomId));
    }

    /**
     * send login message.
     * */
    private void login(){
        socketUtil.send(Constants.loginMessage(roomId));
    }

    public boolean addListener(MsgListener<? extends BaseMsg> listener){
        return core.registerListener(listener);
    }
}
