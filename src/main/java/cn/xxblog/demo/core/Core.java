package cn.xxblog.demo.core;

import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.converter.MsgConverter;
import cn.xxblog.demo.listener.DefaultMsgListener;
import cn.xxblog.demo.listener.MsgListener;
import cn.xxblog.demo.util.MessageUtil;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author Devpan
 */
public class Core {

    static Map<String, MsgConverter> registerConverter;
    static Map<MsgTypeEnum, List<MsgListener>> listenerMap;
    static DefaultMsgListener defaultMsgListener;
    static Boolean enableDefaultListener;


    public Core() {
        registerConverter = new HashMap<>();
        listenerMap = new HashMap<>();
        defaultMsgListener = new DefaultMsgListener();
        enableDefaultListener = true;
    }

    public boolean registerListener(MsgListener msgListener) {
        MsgTypeEnum msgType = Optional.ofNullable(msgListener.getClass().getAnnotation(MsgType.class)).orElseThrow(RuntimeException::new).msgType();
        if (listenerMap.containsKey(msgType)) {
            listenerMap.get(msgType).add(msgListener);
        } else {
            listenerMap.put(msgType, Lists.newArrayList(msgListener));
        }
        enableDefaultListener = false;
        return true;
    }

    public void handMessage(String message) {
        //todo

        // parse message type
        MsgTypeEnum msgTypeEnum = MessageUtil.parseMessageType(message);
        // find msg listener
        if (Objects.nonNull(msgTypeEnum)) {
            if (listenerMap.containsKey(msgTypeEnum)) {
                List<MsgListener> msgListeners = listenerMap.get(msgTypeEnum);
                // each call all listener.handleMessage method
                msgListeners.forEach(l -> l.handleMessage(msgTypeEnum, message));
            } else if (enableDefaultListener) {
                // if not register any listener, fail-back to use default message listener
                defaultMsgListener.handleMessage(MsgTypeEnum.ALL_MESSAGE, message);
            }
        }
    }

    public boolean checkListener() {
        return listenerMap.isEmpty();
    }
}
