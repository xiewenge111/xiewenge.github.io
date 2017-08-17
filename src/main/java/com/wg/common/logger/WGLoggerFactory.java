package com.wg.common.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 文歌 on 2017/7/29.
 */
public class WGLoggerFactory {

    public static wgLogger getLogger(String name) {
        Logger logger = (Logger) LoggerFactory.getLogger(name);
        wgLogger loggerImpl = new wgLogger();
        loggerImpl.setLogger(logger);
        return loggerImpl;
    }
    /**
     * 根据所在类获取logger
     *
     * @param clazz
     *            the returned logger will be named after clazz
     * @return logger
     */
    public static wgLogger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }
}
