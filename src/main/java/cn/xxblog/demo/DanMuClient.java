package cn.xxblog.demo;

import cn.xxblog.demo.util.SocketUtil;

public class DanMuClient {

    private SocketUtil socketUtil;
    private Integer roomId;

    public DanMuClient(Integer roomId){
        socketUtil = new SocketUtil();
        this.roomId = roomId;
    }


    public void login(){

    }
}
