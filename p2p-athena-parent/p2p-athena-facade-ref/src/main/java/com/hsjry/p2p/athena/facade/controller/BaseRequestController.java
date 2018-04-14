package com.hsjry.p2p.athena.facade.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hsjry.p2p.athena.biz.bean.BaseBean;
import com.hsjry.p2p.athena.biz.bean.BaseRequest;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.facade.request.CommonRequest;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public class BaseRequestController  {

    private final static Log log = Log.get(BaseRequestController.class);

    /**
     * 入参校验
     * @param request
     */
    public void checkRequestParameter(CommonRequest request) {
        PreconditionUtils.checkNotNull(request, "请求入参不能为空", EnumErrorCode.PARAMETER_ERROR);
        log.info("请求入参：" + JSONUtils.toJSONString(request));
    }

    /**
     * 验签校验
     * @param request
     */
    public void checkCertSign(CommonRequest request) {
        //TODO:
    }

}
