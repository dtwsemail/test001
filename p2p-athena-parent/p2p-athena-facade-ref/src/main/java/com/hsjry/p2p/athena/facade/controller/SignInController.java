package com.hsjry.p2p.athena.facade.controller;

import com.hsjry.p2p.athena.biz.service.RequestProcessor;
import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.facade.request.BaseRequest;
import com.hsjry.p2p.athena.facade.request.SignInRequest;
import com.hsjry.p2p.athena.facade.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangyf14377 on 2018/5/9.
 */
@Controller
@RequestMapping("/signIn")
public class SignInController extends BaseRequestController {

    @Autowired
    private RequestProcessor requestProcessor;

    @RequestMapping(value = "/doJSON",method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public CommonResponse doJSON(@RequestBody SignInRequest request) {
        return doRequest(request);
    }

    @Override
    public void checkBizParameter(BaseRequest request) {
        //没有业务参数需要校验
    }

    @Override
    public RequestProcessor getRequestProcessor() {
        return requestProcessor;
    }
}
