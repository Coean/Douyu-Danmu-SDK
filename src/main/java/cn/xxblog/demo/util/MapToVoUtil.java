package cn.xxblog.demo.util;

import cn.xxblog.demo.vo.message.BaseMsg;

import java.util.Map;

public class MapToVoUtil<T extends BaseMsg> {
    public T convertByMap(Map<String, String> map) {
        Class<?> genericSuperclass = (Class<?>) getClass().getGenericSuperclass();
        System.out.println(genericSuperclass);
        return null;
    }
}
