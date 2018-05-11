package com.hsjry.p2p.athena.biz.factory;

import com.hsjry.p2p.athena.dal.dao.AthenaBizSerialDao;
import com.hsjry.p2p.athena.dal.dao.AthenaBizSerialExtDao;
import com.hsjry.p2p.athena.dal.integration.common.response.OpenAccountBean;
import com.hsjry.p2p.athena.dal.integration.common.response.SignInBean;
import com.hsjry.p2p.athena.dal.integration.service.ServantSignService;
import com.hsjry.p2p.athena.facade.request.BaseRequest;
import com.hsjry.p2p.athena.facade.request.SignInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 明泰
 * <p>
 * Created by wangyf14377 on 2018/4/9.
 */
@Service
public class MTBankFactory extends AbstractCustodianFactory {

    @Resource(name="MTServantSignService")
    private ServantSignService servantSignService;
    @Autowired
    private AthenaBizSerialDao athenaBizSerialDao;
    @Autowired
    private AthenaBizSerialExtDao athenaBizSerialExtDao;

    @Override
    AthenaBizSerialDao getAthenaBizSerialDao() {
        return athenaBizSerialDao;
    }

    @Override
    AthenaBizSerialExtDao getAthenaBizSerialExtDao() {
        return athenaBizSerialExtDao;
    }



    @Override
    OpenAccountBean openAccountForCompany(String partnerId, String partnerSerialNo, BaseRequest request) {

        return null;
    }

    @Override
    SignInBean SignIn(String partnerId, String partnerSerialNo, BaseRequest request) {
        return servantSignService.doService((SignInRequest) request);
    }




}
