package cn.xxblog.demo.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import cn.xxblog.demo.vo.message.BaseMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 */
@Slf4j
public class MapToVoUtil<T extends BaseMsg> {

    public T convertByMap(Map<String, String> map, Class<T> tClass) {
        T result = null;
        try {
            result = tClass.newInstance();
            for (Field field : tClass.getDeclaredFields()) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), tClass);
                Method method = pd.getWriteMethod();
                method.invoke(result, map.get(field.getName()));
            }
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (IntrospectionException | InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return result;
    }
}
