package cn.xxblog.demo.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.converter.MsgConverter;
import cn.xxblog.demo.listener.MsgListener;
import cn.xxblog.demo.vo.BaseMsg;
import com.google.common.collect.Lists;

/**
 * @author Devpan
 */
public class Core {

    static Map<String, MsgConverter> registerConverter;
    static Map<MsgTypeEnum, List<MsgListener<? extends BaseMsg>>> listenerMap;

    public Core() {
        registerConverter = new HashMap<>();
        listenerMap = new HashMap<>();
    }

    public boolean registerListener(MsgListener<? extends BaseMsg> msgListener) {
        MsgType msgType = Optional.ofNullable(msgListener.getClass().getAnnotation(MsgType.class)).orElseThrow(RuntimeException::new);
        return listenerMap.putIfAbsent(msgType.msgType(), Lists.newArrayList(msgListener)).add(msgListener);
    }

    public void handMessage(String message) {
        //todo

        // parse message type

        // find msg listener

        // if not found listener, fail-back to use default message listener

        // add all message listener

        // each call all listener.handleMessage method

        System.out.println(message);
    }

    public boolean checkListener() {
        return listenerMap.isEmpty();
    }
}
