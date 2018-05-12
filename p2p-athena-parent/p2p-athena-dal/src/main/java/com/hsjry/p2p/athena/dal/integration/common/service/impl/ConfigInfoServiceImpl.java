package com.hsjry.p2p.athena.dal.integration.common.service.impl;

import com.hsjry.p2p.athena.common.constants.EnumCustodianType;
import com.hsjry.p2p.athena.dal.dao.AthenaConfigPartnerInfoDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaConfigPartnerInfo;
import com.hsjry.p2p.athena.dal.integration.common.response.ServantInfoBean;
import com.hsjry.p2p.athena.dal.integration.service.ConfigInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取配置信息（与租户无关）
 * Created by wangyf14377 on 2018/4/14.
 */
@Service
public class ConfigInfoServiceImpl implements ConfigInfoService {

    @Autowired
    private AthenaConfigPartnerInfoDao athenaConfigPartnerInfoDao;

//    @Override
//    public AthenaConfigPartnerInfo getConfigPartnerInfo(String partnerId) {
//        AthenaConfigPartnerInfo info = athenaConfigPartnerInfoDao.selectByParnterId(partnerId);
//        return info;
//    }


    @Override
    public ServantInfoBean getServantInfoBean(String partnerId){
        AthenaConfigPartnerInfo info = athenaConfigPartnerInfoDao.selectByParnterId(partnerId);
        if (info == null) {
            return null;
        }
        ServantInfoBean bean =  new ServantInfoBean();
        bean.setPartnerId(info.getPartnerId());
        bean.setPartnerCode(info.getPartnerCode());
        bean.setPartnerName(info.getPartnerName());
        bean.setBankCode(info.getBankCode());
        bean.setBankName(info.getBankName());
        bean.setCustodianType(EnumCustodianType.find(info.getCustodianType()));
        return bean;
    }
}
