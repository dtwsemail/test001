package com.hsjry.p2p.athena.biz.processor;

import com.hsjry.p2p.athena.biz.bean.BaseBean;
import com.hsjry.p2p.athena.biz.bean.BaseRequest;
import com.hsjry.p2p.athena.biz.factory.AbstractCustodianFactory;
import com.hsjry.p2p.athena.biz.factory.MTBankFactory;
import com.hsjry.p2p.athena.biz.service.RequestProcessor;
import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.common.constants.EnumCustodianType;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
@Service
public class CommonRequestProcessor implements RequestProcessor {

    //日志
    private final static Log log = Log.get(CommonRequestProcessor.class);

    @Autowired
    private MTBankFactory mtBankFactory;

    @Transactional
    public BaseBean process(BaseRequest request) {
        AbstractCustodianFactory factory = getCustodianFactory(request.getPartnerId());
        BaseBean result = factory.process(request);
        return result;
    }

    //获取存管工厂
    private AbstractCustodianFactory  getCustodianFactory(String partnerId ){
        AbstractCustodianFactory result = null;
        //托管机构类型
        EnumCustodianType custodianType = null;

        log.info("存管类型：" + custodianType);

        switch (custodianType) {
            case MTBank:
                result = mtBankFactory;
            default:
                PreconditionUtils.throwException(partnerId, "合作商编号对应的存管类型不存在", EnumErrorCode.PARAMETER_ERROR);
        }
        return result;
    }
}
