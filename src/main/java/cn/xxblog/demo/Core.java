package cn.xxblog.demo;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Core {

    private static Core core = null;

    static Map<String, MsgConverter> registerConverter;

    private Core() {
    }

    public static synchronized Core getInstance() {
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

    public void handMessage(String message) {
        System.out.println(message);
    }
}
