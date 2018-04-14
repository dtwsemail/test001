package com.hsjry.p2p.athena.dal.dao.impl;

import com.hsjry.p2p.athena.common.constants.EnumBool;
import com.hsjry.p2p.athena.dal.dao.AthenaConfigPartnerInfoDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaConfigPartnerInfo;
import com.hsjry.p2p.athena.dal.dao.model.AthenaConfigPartnerInfoExample;
import com.hsjry.p2p.athena.dal.dao.service.AthenaConfigPartnerInfoMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
@Repository
public class AthenaConfigPartnerInfoDaoImpl implements AthenaConfigPartnerInfoDao {
    private AthenaConfigPartnerInfoMapper athenaConfigPartnerInfoMapper;

    @Override
    public AthenaConfigPartnerInfo selectByParnterId(String partnerId) {
        AthenaConfigPartnerInfoExample example = new AthenaConfigPartnerInfoExample();
        example.createCriteria().andPartnerIdEqualTo(partnerId).andStatusEqualTo(EnumBool.TRUE.getCode());
        List<AthenaConfigPartnerInfo> list = athenaConfigPartnerInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
