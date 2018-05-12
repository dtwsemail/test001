package com.hsjry.p2p.athena.facade.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hsjry.p2p.athena.biz.service.RequestProcessor;
import com.hsjry.p2p.athena.common.constants.Constants;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.common.utils.JsonUtils;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.dal.integration.common.response.BaseBean;
import com.hsjry.p2p.athena.facade.request.BaseRequest;
import com.hsjry.p2p.athena.facade.response.CommonResponse;
import com.hsjry.p2p.athena.facade.utils.ResponseGenerator;

/**
 * 业务请求统一处理模板类
 * Created by wangyf14377 on 2018/4/9.
 */
public abstract class BaseRequestController {

    private final static Log log = Log.get(BaseRequestController.class);


    public abstract void checkBizParameter(BaseRequest request);

    public abstract RequestProcessor getRequestProcessor();

    public CommonResponse doRequest(BaseRequest request) {

        try {
            //记录请求处理时间
            long startTime = System.nanoTime();
            //打印请求参数
            requestLog(request);
            //入参非空校验
            checkRequestParameter(request);
            //业务参数校验
            checkBizParameter(request);
            //验签校验
            checkCertSign(request);
            //流水号幂等性校验
            checkIdempotent(request);
            //业务处理
            BaseBean returnObj = process(request);
            String partnerId = request.getPartnerId();
            String partnerSerialNo = request.getPartnerSerialNo();
            //返回成功结果
            CommonResponse response = ResponseGenerator.generatorSuccessResponse(partnerId, partnerSerialNo, returnObj);
            //打印返回结果参数
            responseLog(response, startTime);

            return response;
        } catch (Exception e) {
            //记录异常日志
            exceptionLog(request, e);
            //异常处理
            dealException(request, e);
        }

        return null;
    }

    /**
     * 业务处理
     *
     * @param request
     * @return
     */
    public BaseBean process(BaseRequest request) {
//        BaseRequest baseRequest = new BaseRequest(request.getPartnerId(), request.getPartnerSerialNo(), request.getBizType(), request.getParameter());
        return getRequestProcessor().process(request);
    }

    /**
     * 入参校验
     *
     * @param request
     */
    public void checkRequestParameter(BaseRequest request) {
        PreconditionUtils.checkNotNull(request.getPartnerId(), request, "请求入参不能为空", EnumErrorCode.PARAMETER_ERROR);
        log.info("请求入参：" +JsonUtils.toJSONString(request));
    }

    /**
     * 验签校验
     *
     * @param request
     */
    public void checkCertSign(BaseRequest request) {
        //TODO:
    }

    /**
     * 幂等校验
     *
     * @param request
     */
    public void checkIdempotent(BaseRequest request) {

    }

    /**
     * 打印请求参数
     *
     * @param request
     */
    public void requestLog(BaseRequest request) {

    }

    /**
     * 打印返回结果
     *
     * @param response
     */
    public void responseLog(CommonResponse response, long startTime) {

    }

    /**
     * 异常日志打印
     */

    public void exceptionLog(BaseRequest request, Exception e) {
        String requestMessage = request == null ? Constants.EMPTY_STRING : JsonUtils.toJSONString(request);
        log.error(e, "系统异常,请求参数：" + requestMessage);
    }

    /**
     * 异常处理
     *
     * @param request
     * @param e
     */
    public void dealException(BaseRequest request, Exception e) {

    }
}
