package com.hsjry.p2p.athena.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhang on 15/10/17.
 */
public abstract class AbstractLog {
    //----------------------------------------------------------- Private method start
    /**
     * 格式化文本
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param values 参数值
     * @return 格式化后的文本
     */
    protected static String format(String template, Object... values) {
        return String.format(template.replace("{}", "%s"), values);
    }

    /**
     * @return 获得日志，自动判定日志发出者
     */
    protected static Logger innerGet() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTrace[3].getClassName());
    }
}
