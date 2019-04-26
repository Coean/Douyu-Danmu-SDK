package cn.xxblog.demo.converter;

import cn.xxblog.demo.vo.BaseMsg;

public interface MsgConverter<T extends BaseMsg> {
     /**
      * convert message
      * @param msg raw message
      * @return Message Entity (extends BaseMsg)
      * */
     T convertMessage(String msg);

}
