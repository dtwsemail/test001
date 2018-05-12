package com.hsjry.p2p.athena.dal.integration.service;

import com.hsjry.p2p.athena.dal.dao.model.AthenaConfigPartnerInfo;
import com.hsjry.p2p.athena.dal.integration.common.response.ServantInfoBean;

/**
 * 获取配置信息
 * Created by wangyf14377 on 2018/4/14.
 */
public interface ConfigInfoService {

    /**
     * 获取租户信息
     * @param partnerId
     * @return
     */
//    AthenaConfigPartnerInfo getConfigPartnerInfo(String partnerId);

    ServantInfoBean getServantInfoBean(String partnerId);
}
