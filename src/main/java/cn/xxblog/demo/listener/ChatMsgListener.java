package cn.xxblog.demo.listener;

import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.vo.message.ChatMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 *     description:
 */
@Slf4j
@MsgType(msgType = MsgTypeEnum.CHAT_MSG)
public class ChatMsgListener implements MsgListener<ChatMsg> {

    @Override
    public void handleMessage(MsgTypeEnum msgType, ChatMsg chatMsg) {
        try {
            log.info("chat: {} ----- {}", chatMsg.getNn(), chatMsg.getTxt());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }

    }

}
