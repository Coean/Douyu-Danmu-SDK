package cn.xxblog.demo.listener;

import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 * description:
 */
@Slf4j
@MsgType(msgType = MsgTypeEnum.DGB)
public class GiftMsgListener implements MsgListener {

    @Override
    public void handleMessage(MsgTypeEnum msgType, String message) {
        log.info("chat:" + message);
    }
}
