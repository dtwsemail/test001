package com.hsjry.p2p.athena.facade.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hsjry.p2p.athena.biz.bean.BaseBean;
import com.hsjry.p2p.athena.biz.bean.BaseRequest;
import com.hsjry.p2p.athena.biz.service.RequestProcessor;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.facade.request.CommonRequest;
import com.hsjry.p2p.athena.facade.response.CommonResponse;
import com.hsjry.p2p.athena.facade.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request")
public class RequestController extends  BaseRequestController {

    private final static Log log = Log.get(RequestController.class);

    @Autowired
    private RequestProcessor requestProcessor;

    @RequestMapping("/doJSON")
    public CommonResponse doRequest(CommonRequest request) {

        try {
            //入参非空校验
            checkRequestParameter(request);
            //验签校验
            checkCertSign(request);
            //业务处理
            BaseBean returnObj = process(request);
            //返回成功结果
            return ResponseGenerator.generatorSuccessResponse(returnObj);

        } catch (Exception e) {
            //TODO:
        }

        return null;
    }

    /**
     * 业务处理
     * @param request
     * @return
     */
    private BaseBean process(CommonRequest request) {
        BaseRequest baseRequest = new BaseRequest(request.getPartnerId(), request.getPartnerSerialNo(), request.getBizType(), request.getParameter());
        return requestProcessor.process(baseRequest);
    }

}
