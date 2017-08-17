package com.wg.common.utils;

import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.time.DateUtils;

public class MapToClassUtils {
    public static final String REQUEST_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 帮助方法，将map 转换为 请求参数BO
     */
    public static <T> T map2Class(Map<String, String> map, Class<T> clazz) throws Exception {
        T requestInstance = clazz.newInstance();
        return populateFromMap(map, requestInstance);
    }

    /**
     * 帮助方法，将map中的内容转填充到请求参数BO
     */
    public static <T> T populateFromMap(Map<String, String> map, T bean) throws Exception {
        registerDateType();
        BeanUtils.populate(bean, map);
        return bean;
    }

    private static void registerDateType() {
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                try {
                    if (type == Date.class && (value != null && value instanceof String))
                        return DateUtils.parseDate((String) value, new String[]{REQUEST_TIME_FORMAT});
                } catch (Exception e) {
                }
                return value;
            }
        }, Date.class);
    }

}
