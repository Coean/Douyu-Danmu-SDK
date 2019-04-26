package cn.xxblog.demo.converter;

import cn.xxblog.demo.vo.BaseMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 */
@Slf4j
public class DefaultMsgConverterImpl<T extends BaseMsg> {

    public T convertMessage(String msg) {
        log.info(msg);
        return null;
    }
}
