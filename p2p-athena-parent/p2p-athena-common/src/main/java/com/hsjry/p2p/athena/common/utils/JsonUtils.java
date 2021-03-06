package com.hsjry.p2p.athena.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hsjry.p2p.athena.common.constants.Constants;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public class JsonUtils {

    public static String toJSONString(Object object) {
        return object == null ? Constants.EMPTY_STRING : JSON.toJSONString(object);
    }

    public static <T> T format(String json, Class<T> clazz) {
        return StringUtils.isBlank(json) ? null : JSONObject.parseObject(json, clazz);
    }
}
