package com.hsjry.p2p.athena.biz.factory;

import com.hsjry.p2p.athena.biz.bean.BaseRequest;
import com.hsjry.p2p.athena.biz.bean.OpenAccountBean;
import org.springframework.stereotype.Service;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
@Service
public class MTBankFactory extends  AbstractCustodianFactory {


    @Override
    OpenAccountBean openAccountForCompany(BaseRequest request) {

        return null;
    }

    
}
