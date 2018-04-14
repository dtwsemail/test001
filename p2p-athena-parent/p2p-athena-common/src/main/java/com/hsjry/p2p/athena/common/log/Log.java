package com.hsjry.p2p.athena.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Log extends AbstractLog {

    private final static Object lock = new Object();

    private Logger logger;

    protected static Map<Object, Log> logMap = new ConcurrentHashMap<Object, Log>();

    protected Log(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    protected Log(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    /**
     * 获得Logger
     *
     * @param clazz 日志发出的类
     *
     * @return Logger
     */
    public static Log get(Class<?> clazz) {
        Log log = logMap.get(clazz);
        if (null == log) {
            synchronized (lock){
                log = new Log(clazz);
                logMap.put(clazz, log);
            }
        }
        return log;
    }

    /**
     * 获得Logger
     *
     * @param name 自定义的日志发出者名称
     *
     * @return Logger
     */
    public static Log get(String name) {
        Log log = logMap.get(name);
        if (null == log) {
            synchronized (lock){
                log = new Log(name);
                logMap.put(name, log);
            }
        }
        return log;
    }

    //----------------------------------------------------------- Logger method start
    //------------------------ Trace

    /**
     * Trace等级日志，小于debug<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void trace(String format, Object... arguments) {
        logger.trace(format, arguments);
    }

    /**
     * Trace等级日志，小于Debug
     *
     * @param logger    日志对象
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void trace(Logger logger, String format, Object... arguments) {
        logger.trace(format, arguments);
    }

    //------------------------ debug

    /**
     * Debug等级日志，小于Info<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void debug(String format, Object... arguments) {
        logger.debug(format, arguments);
    }

    //------------------------ info

    /**
     * Info等级日志，小于Warn<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */


    public void info(String format, Object... arguments) {
        logger.info(format, arguments);
    }

    //------------------------ warn

    /**
     * Warn等级日志，小于Error<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void warn(String format, Object... arguments) {
        logger.warn(format, arguments);
    }

    /**
     * Warn等级日志，小于Error<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param e         需在日志中堆栈打印的异常
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void warn(Throwable e, String format, Object... arguments) {
        warn(e, format(format, arguments));
    }

    //------------------------ error

    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void error(String format, Object... arguments) {
        logger.error(format, arguments);
    }

    /**
     * Error等级日志<br>
     * 由于动态获取Logger，效率较低，建议在非频繁调用的情况下使用！！
     *
     * @param e         需在日志中堆栈打印的异常
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public void error(Throwable e, String format, Object... arguments) {
        logger.error(format(format, arguments), e);
    }

    //----------------------------------------------------------- Logger method end

//    public static void main(String[] args) {
//
//        Log logger = Log.get(Log.class);
//
//        //第一种使用方法（效率低）
//        logger.debug("我是一条debug消息");
//
//        //第二种使用方法
//        logger.debug("我是一条debug消息 {} {}", "参数1", "参数2");
//
//        RuntimeException e = new RuntimeException("错误");
//
//        //第一种使用方法（效率低）
//        logger.error("我是一条error消息");
//
//        //第二种使用方法
//        logger.error(e, "<-异常对象放前面, 我是一条带参数的error消息 {} {}", "参数1", "参数2");
//    }

}
