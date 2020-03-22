package cn.xxblog.demo.converter;

import cn.xxblog.demo.vo.message.BaseMsg;

/**
 * @author Devpan
 */
public interface MsgConverter<T extends BaseMsg> {
    /**
     * convert message
     *
     * @param msg raw message
     * @param msgTypeClass
     * @return Message Entity (extends BaseMsg)
     */
    T convertMessage(String msg, Class<T> msgTypeClass);

}
