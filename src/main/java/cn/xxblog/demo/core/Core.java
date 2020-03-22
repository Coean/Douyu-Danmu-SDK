package cn.xxblog.demo.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.converter.DefaultMsgConverterImpl;
import cn.xxblog.demo.converter.MsgConverter;
import cn.xxblog.demo.listener.DefaultMsgListener;
import cn.xxblog.demo.listener.MsgListener;
import cn.xxblog.demo.util.MessageUtil;
import cn.xxblog.demo.vo.message.BaseMsg;
import com.google.common.collect.Lists;

/**
 * @author Devpan
 */
public class Core<T extends BaseMsg> {

    static Map<String, MsgConverter> registerConverter;
    static Map<MsgTypeEnum, List<MsgListener>> listenerMap;
    static DefaultMsgListener defaultMsgListener;
    static Boolean enableDefaultListener;
    DefaultMsgConverterImpl<T> defaultMsgConverter;

    public Core() {
        registerConverter = new HashMap<>();
        listenerMap = new HashMap<>();
        defaultMsgListener = new DefaultMsgListener();
        enableDefaultListener = true;
        defaultMsgConverter = new DefaultMsgConverterImpl();

    }

    public boolean registerListener(MsgListener msgListener) {
        MsgTypeEnum msgType = Optional.ofNullable(msgListener.getClass().getAnnotation(MsgType.class)).orElseThrow(RuntimeException::new).msgType();
        //todo need check msgtype same as return value type
        if (listenerMap.containsKey(msgType)) {
            listenerMap.get(msgType).add(msgListener);
        } else {
            listenerMap.put(msgType, Lists.newArrayList(msgListener));
        }
        enableDefaultListener = false;
        return true;
    }

    public void handMessage(String message) {
        // parse message type
        MsgTypeEnum msgTypeEnum = MessageUtil.parseMessageType(message);
        // find msg listener
        if (Objects.nonNull(msgTypeEnum)) {
            if (listenerMap.containsKey(msgTypeEnum)) {
                List<MsgListener> msgListenerList = listenerMap.get(msgTypeEnum);
                //parse message
                BaseMsg msg = defaultMsgConverter.convertMessage(message, msgTypeEnum.getMsgClassType());
                // each call all listener.handleMessage method
                msgListenerList.forEach(l -> l.handleMessage(msgTypeEnum, msg));
            } else if (enableDefaultListener) {
                //parse message
                BaseMsg msg = defaultMsgConverter.convertMessage(message, MsgTypeEnum.ALL_MESSAGE.getMsgClassType());
                // if not register any listener, fail-back to use default message listener
                defaultMsgListener.handleMessage(MsgTypeEnum.ALL_MESSAGE, msg);
            }
        }
        if (listenerMap.containsKey(MsgTypeEnum.ALL_MESSAGE)) {
            //parse message
            BaseMsg msg = defaultMsgConverter.convertMessage(message, MsgTypeEnum.ALL_MESSAGE.getMsgClassType());
            listenerMap.get(MsgTypeEnum.ALL_MESSAGE).forEach(l -> l.handleMessage(msgTypeEnum, msg));
        }
    }

    public boolean checkListener() {
        return listenerMap.isEmpty();
    }
}
