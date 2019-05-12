package cn.xxblog.demo.converter;

import cn.xxblog.demo.vo.message.ChatMsg;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Devpan
 */
@Slf4j
public class ChatMsgConverterImpl {

    public ChatMsg convertMessage(String msg) {
        Map<String, String> map = new HashMap<>();
        String[] kv = msg.split("/");
        for (String s : kv) {
            String[] temp = s.split("@=");
            if (temp.length == 2) {
                map.put(temp[0], temp[1]);
            }
        }
        ChatMsg chatMsg = new ChatMsg();
        return null;
    }
}
