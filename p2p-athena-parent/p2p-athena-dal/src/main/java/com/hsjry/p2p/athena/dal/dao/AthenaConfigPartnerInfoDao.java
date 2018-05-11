package com.hsjry.p2p.athena.dal.dao;

import com.hsjry.p2p.athena.dal.dao.model.AthenaConfigPartnerInfo;

/**
 * Created by wangyf14377 on 2018/5/11.
 */
public interface AthenaConfigPartnerInfoDao {
    AthenaConfigPartnerInfo selectByParnterId(String partnerId);
}
