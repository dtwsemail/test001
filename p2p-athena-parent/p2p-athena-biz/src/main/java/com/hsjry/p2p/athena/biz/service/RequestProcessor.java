package com.hsjry.p2p.athena.biz.service;

import com.hsjry.p2p.athena.dal.integration.common.response.BaseBean;
import com.hsjry.p2p.athena.facade.request.BaseRequest;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public interface RequestProcessor {
    BaseBean process(BaseRequest request);
}
