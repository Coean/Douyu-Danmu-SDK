package cn.xxblog.demo.util;

import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.exception.DouyuSdkCommonException;
import cn.xxblog.demo.vo.message.ChatMsg;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author barryp
 * @create 2019-04-30 17:10
 * description:
 */
@Slf4j
public class MessageUtil {

    private static Pattern pattern = Pattern.compile("type@=\\w+");

    public static MsgTypeEnum parseMessageType(String msg) {
        if (Objects.isNull(msg)) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(msg);
            if (matcher.find()) {
                return MsgTypeEnum.findByName(matcher.group().replace("type@=", ""));
            }
        } catch (IllegalArgumentException e) {
            log.debug("解析msg type失败," + e.getLocalizedMessage());
        } catch (DouyuSdkCommonException e) {
            log.debug("not found message type: {}", msg);
        }
        return null;
    }

    public static Map<String,String> splitMessage(String msg) {
        if (Objects.isNull(msg)) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        try {
            String[] objArr = msg.split("/");
            for (String s : objArr) {
                String[] kv = s.split("@=");
                if (kv.length == 2) {
                    map.put(kv[0], kv[1]);
                }
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return map;
    }



}
