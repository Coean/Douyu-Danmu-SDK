package cn.xxblog.demo.listener;

import cn.xxblog.demo.common.MsgTypeEnum;

/**
 * @author barryp
 * @create 2019-04-26 13:01
 * description:
 */
public interface MsgListener {

    /**
     * @param message raw mssage from douyu server.
     * @param msgType message type
     * @return String message
     */
    void handleMessage(MsgTypeEnum msgType, String message);

}
