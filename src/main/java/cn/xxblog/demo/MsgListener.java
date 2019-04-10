package cn.xxblog.demo;

public interface MsgListener<T extends BaseMsg> {
     void handleMessage(T msg);
}
