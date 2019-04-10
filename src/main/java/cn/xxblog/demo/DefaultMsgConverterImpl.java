package cn.xxblog.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultMsgConverterImpl<T extends BaseMsg> implements MsgConverter<T> {

    @Override
    public T convertMessage(String msg) {
        log.info(msg);
        return null;
    }

    @Override
    public MsgTypeEnum converterMsgType() {
        return MsgTypeEnum.CHAT_MSG;
    }
}
