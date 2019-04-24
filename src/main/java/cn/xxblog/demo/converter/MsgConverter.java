package cn.xxblog.demo.converter;

import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.vo.BaseMsg;

public interface MsgConverter<T extends BaseMsg> {
     T convertMessage(String msg);

     MsgTypeEnum converterMsgType();
}
