package cn.xxblog.demo.listener;

import cn.xxblog.demo.vo.BaseMsg;

public interface MsgListener<T extends BaseMsg> {
     void handleMessage(T msg);
}
