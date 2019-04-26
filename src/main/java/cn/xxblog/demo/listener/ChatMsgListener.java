package cn.xxblog.demo.listener;
import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.vo.BaseMsg;

/**
 * @author devpan
 *     description:
 */
@MsgType(msgType = MsgTypeEnum.CHAT_MSG)
public class ChatMsgListener implements MsgListener<BaseMsg> {

    @Override
    public void handleMessage(BaseMsg rawMsg) {
        System.out.println(rawMsg);
    }
}
