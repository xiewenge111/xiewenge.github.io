package com.wg.common.logger;

/**
 * Created by 文歌 on 2017/7/29.
 */
public class wgLogger extends LoggerImpl{
    @Override
    public void trace(String msg) {
        if (logger.isTraceEnabled()) {
            logger.trace(msg);
        }
    }

    @Override
    public void trace(String format, Object arg) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, arg);
        }
    }

    @Override
    public void trace(String format, Object[] argArray) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, argArray);
        }
    }

    @Override
    public void trace(String msg, Throwable t) {
        if (logger.isTraceEnabled()) {
            logger.trace(msg, t);
        }
    }

    @Override
    public void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public void debug(String format, Object arg) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, arg);
        }
    }

    @Override
    public void debug(String format, Object[] argArray) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, argArray);
        }
    }

    @Override
    public void debug(String message, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, t);
        }
    }

    @Override
    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    @Override
    public void info(String format, Object arg) {
        if (logger.isInfoEnabled()) {
            logger.info(format, arg);
        }

    }

    @Override
    public void info(String format, Object[] argArray) {
        if (logger.isInfoEnabled()) {
            logger.info(format, argArray);
        }
    }

    @Override
    public void info(String msg, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, t);
        }
    }

    @Override
    public void warn(String msg) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    @Override
    public void warn(String format, Object arg) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, arg);
        }
    }

    @Override
    public void warn(String format, Object[] argArray) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, argArray);
        }
    }

    @Override
    public void warn(String msg, Throwable t) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, t);
        }
    }

    @Override
    public void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    @Override
    public void error(String message, Throwable t) {
        if (logger.isErrorEnabled()) {
            logger.error(message, t);
        }
    }

}
