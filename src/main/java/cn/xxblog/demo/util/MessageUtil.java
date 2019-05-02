package cn.xxblog.demo.util;

import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.exception.DouyuSdkCommonException;
import lombok.extern.slf4j.Slf4j;

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

}
