package cn.xxblog.demo;

import java.util.HashMap;
import java.util.Map;

public class Core {

    private static Core core = null;

    Map<String, MsgConverter> registerConverter;

    private Core() {
    }

    public synchronized Core getInstance() {
        if (core == null) {
            core = new Core();
            registerConverter = new HashMap<>();
        }
        return core;
    }


    public boolean registeConverter(MsgConverter msgConverter) {
        registerConverter.put(msgConverter.converterMsgType().getType(), msgConverter);
        return true;
    }
}
