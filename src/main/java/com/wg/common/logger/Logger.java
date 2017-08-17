package com.wg.common.logger;

/**
 * Created by 文歌 on 2017/7/29.
 */
public interface Logger {
    String getName();

    boolean isTraceEnabled();

    void trace(String var1);

    void trace(String var1, Object var2);

    void trace(String var1, Object[] var2);

    void trace(String var1, Throwable var2);

    boolean isDebugEnabled();

    void debug(String var1);

    void debug(String var1, Object var2);

    void debug(String var1, Object[] var2);

    void debug(String var1, Throwable var2);

    boolean isInfoEnabled();

    void info(String var1);

    void info(String var1, Object var2);

    void info(String var1, Object[] var2);

    void info(String var1, Throwable var2);

    boolean isWarnEnabled();

    void warn(String var1);

    void warn(String var1, Object var2);

    void warn(String var1, Object[] var2);

    void warn(String var1, Throwable var2);

    boolean isErrorEnabled();

    void error(String var1);

    void error(String var1, Throwable var2);
}
