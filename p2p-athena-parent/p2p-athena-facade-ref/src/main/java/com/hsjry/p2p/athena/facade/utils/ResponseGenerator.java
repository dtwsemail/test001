package com.hsjry.p2p.athena.facade.utils;

import com.hsjry.p2p.athena.biz.bean.BaseBean;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.utils.DateUtil;
import com.hsjry.p2p.athena.common.utils.JsonUtils;
import com.hsjry.p2p.athena.facade.response.CommonResponse;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public class ResponseGenerator {

    public static CommonResponse generatorSuccessResponse(BaseBean object) {
        CommonResponse response = new CommonResponse();
        response.setReturnObj(JsonUtils.toJSONString(object));
        response.setCode(EnumErrorCode.SUCCESS.getErrorCode());
        response.setMessage(EnumErrorCode.SUCCESS.getErrorDesc());
        response.setTime(DateUtil.getNow());
        //TODO:
        response.setCertSign(null);
        return response;
    }

}
