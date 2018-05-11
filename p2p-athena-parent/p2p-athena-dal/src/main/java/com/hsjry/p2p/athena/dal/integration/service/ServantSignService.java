package com.hsjry.p2p.athena.dal.integration.service;

import com.hsjry.p2p.athena.dal.integration.common.response.SignInBean;
import com.hsjry.p2p.athena.facade.request.SignInRequest;

/**
 * 商户签到接口
 * Created by wangyf14377 on 2018/4/14.
 */
public interface ServantSignService {
    SignInBean doService(SignInRequest request);
}
