package cn.xxblog.demo.listener;

import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.vo.message.BaseMsg;

/**
 * @author barryp
 * @create 2019-04-26 13:01
 * description:
 */
public interface MsgListener<T extends BaseMsg> {

    /**
     * @param message raw mssage from douyu server.
     * @param msgType message type
     * @return String message
     */
    void handleMessage(MsgTypeEnum msgType, T message);

}
