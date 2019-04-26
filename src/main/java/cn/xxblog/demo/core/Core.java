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

public class Core {

    static Map<String, MsgConverter> registerConverter;
    static Map<MsgTypeEnum, List<MsgListener<? extends BaseMsg>>> listenerMap;

    public Core() {
        registerConverter = new HashMap<>();
        listenerMap = new HashMap<>();
    }

    //    public boolean registerConverter(MsgConverter msgConverter) {
    //        registerConverter.put(msgConverter.converterMsgType().getType(), msgConverter);
    //        return true;
    //    }

    public boolean registerListener(MsgListener<? extends BaseMsg> msgListener) {
        MsgType msgType = Optional.ofNullable(msgListener.getClass().getAnnotation(MsgType.class)).orElseThrow(() -> new RuntimeException());
        return listenerMap.putIfAbsent(msgType.msgType(), Lists.newArrayList(msgListener)).add(msgListener);
    }

    public void handMessage(String message) {
        //todo

        System.out.println(message);
    }

    public boolean checkListener() {
        return listenerMap.isEmpty();
    }
}
