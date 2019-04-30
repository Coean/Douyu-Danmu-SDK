package cn.xxblog.demo.util;
import java.util.Objects;
import java.util.regex.Pattern;

import cn.xxblog.demo.common.MsgTypeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author barryp
 * @create 2019-04-30 17:10
 *     description:
 */
@Slf4j
public class MessageUtil {

    private static Pattern pattern = Pattern.compile("type@=\\w+");

    public static MsgTypeEnum parseMessageType(String msg) {
        if (Objects.isNull(msg)) {
            return null;
        }
        try {
            String msgType = pattern.matcher(msg).group();
            return MsgTypeEnum.valueOf(msgType);
        } catch (IllegalArgumentException e) {
            log.error("解析msg type失败," + e.getLocalizedMessage(), e);
        }
        return null;
    }

}
