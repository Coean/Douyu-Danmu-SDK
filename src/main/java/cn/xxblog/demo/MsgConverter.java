package cn.xxblog.demo;

public interface MsgConverter<T extends BaseMsg> {
     T convertMessage(String msg);

     MsgTypeEnum converterMsgType();
}
