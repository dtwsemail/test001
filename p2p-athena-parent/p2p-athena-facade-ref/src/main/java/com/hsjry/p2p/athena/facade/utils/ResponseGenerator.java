package com.hsjry.p2p.athena.facade.utils;

import com.hsjry.p2p.athena.dal.integration.common.response.BaseBean;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.utils.DateUtil;
import com.hsjry.p2p.athena.common.utils.JsonUtils;
import com.hsjry.p2p.athena.facade.response.CommonResponse;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public class ResponseGenerator {

    public static CommonResponse generatorSuccessResponse(String partnerId , String partnerserialNo,BaseBean object) {
        CommonResponse response = new CommonResponse();
        response.setPartnerId(partnerId);
        response.setPartnerSerialNo(partnerserialNo);
        response.setReturnObj(JsonUtils.toJSONString(object));
        response.setCode(EnumErrorCode.SUCCESS.getErrorCode());
        response.setMessage(EnumErrorCode.SUCCESS.getErrorDesc());
        response.setTime(DateUtil.getNow().getTime());
        //TODO:
        response.setCertSign(null);
        return response;
    }

}
