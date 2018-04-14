package com.hsjry.p2p.athena.common.utils;

import com.hsjry.p2p.athena.common.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public class DateUtil {

    public final static SimpleDateFormat SIMPLE_DATE_FORMAT  = new SimpleDateFormat("yyyyMMdd");
    public final static SimpleDateFormat SIMPLE_TIME_FORMAT  = new SimpleDateFormat("hhMMss");
//
//    public static long getNow(){
//        return new Date().getTime();
//    }
    public static Date getNow(){
        return new Date();
    }

    public static String format(Date date, SimpleDateFormat format){
        if(date ==null || format==null){
            return Constants.EMPTY_STRING;
        }
        return format.format(date);
    }

    public static void main(String[] args) {

    }
}
