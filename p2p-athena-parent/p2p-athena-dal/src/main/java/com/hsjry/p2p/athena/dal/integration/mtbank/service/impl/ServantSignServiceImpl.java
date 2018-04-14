package com.hsjry.p2p.athena.dal.integration.mtbank.service.impl;

import com.hsjry.p2p.athena.dal.dao.AthenaConfigPartnerInfoDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaConfigPartnerInfo;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.ServantSignReq;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.bean.ServantSignBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlRequestBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.service.MTSocketSerivce;
import com.hsjry.p2p.athena.dal.integration.service.SerialNoService;
import com.hsjry.p2p.athena.dal.integration.service.ServantSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
@Service
public class ServantSignServiceImpl implements ServantSignService {

    @Autowired
    private AthenaConfigPartnerInfoDao athenaConfigPartnerInfoDao;
    @Autowired
    private SerialNoService serialNoService;
    @Autowired
    private MTSocketSerivce mtSocketSerivce;

    public void doService(String partnerId) {
        mtSocketSerivce.doService(getRequestBean(partnerId));
    }

    public ServantSignBean getRequestBean(String partnerId) {
        {

            AthenaConfigPartnerInfo info = athenaConfigPartnerInfoDao.selectByParnterId(partnerId);
            String serialNo = serialNoService.generateCommonSerivce();

            ServantSignReq req = new ServantSignReq(serialNo,info.getPartnerCode(),info.getPartnerName(),info.getBankCode(),info.getBankName());
            ServantSignBean bean = ServantSignBean.generate(req);

            return bean;
        }
    }
}
