package cn.xxblog.demo.converter;

import java.util.Map;
import java.util.Objects;

import cn.xxblog.demo.util.MapToVoUtil;
import cn.xxblog.demo.util.MessageUtil;
import cn.xxblog.demo.vo.message.BaseMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 */
@Slf4j
public class DefaultMsgConverterImpl<T extends BaseMsg> implements MsgConverter<T> {

    private MapToVoUtil<T> util = new MapToVoUtil<>();

    @Override
    public T convertMessage(String msg, Class<T> msgTypeClass) {
        if (Objects.isNull(msg) || msg.isEmpty()) {
            T t = null;
            try {
                t = msgTypeClass.newInstance();
            } catch (ReflectiveOperationException e) {
                log.error(e.getLocalizedMessage(), e);
            }
            return t;
        }
        Map<String, String> map = MessageUtil.splitMessage(msg);
        T t = util.convertByMap(map, msgTypeClass);
        t.setRawMessage(msg);
        return t;
    }
}
