package com.hsjry.p2p.athena.biz.service;

import com.hsjry.p2p.athena.biz.bean.BaseBean;
import com.hsjry.p2p.athena.biz.bean.BaseRequest;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public interface RequestProcessor {
     BaseBean process(BaseRequest request);
}
