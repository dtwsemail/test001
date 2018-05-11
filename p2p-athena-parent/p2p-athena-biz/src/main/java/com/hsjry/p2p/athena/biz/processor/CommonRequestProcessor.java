package com.hsjry.p2p.athena.biz.processor;

import com.hsjry.p2p.athena.dal.integration.common.response.BaseBean;
import com.hsjry.p2p.athena.biz.factory.AbstractCustodianFactory;
import com.hsjry.p2p.athena.biz.factory.MTBankFactory;
import com.hsjry.p2p.athena.biz.service.RequestProcessor;
import com.hsjry.p2p.athena.common.constants.EnumCustodianType;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.dal.integration.common.response.ServantInfoBean;
import com.hsjry.p2p.athena.dal.integration.service.ConfigInfoService;
import com.hsjry.p2p.athena.facade.request.BaseRequest;
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

    @Autowired
    private ConfigInfoService configInfoService;

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
        ServantInfoBean bean  = configInfoService.getServantInfoBean(partnerId);
        PreconditionUtils.checkNotNull(partnerId,bean,"服务商配置信息不存在",EnumErrorCode.CONFIG_ERROR);
        EnumCustodianType custodianType = bean.getCustodianType();
        PreconditionUtils.checkNotNull(partnerId,custodianType,"未配置存管机构",EnumErrorCode.CONFIG_ERROR);
        log.info("存管类型：" + custodianType.getDescription());

        switch (custodianType) {
            case MTBank:
                result = mtBankFactory;
                break;
            default:
                PreconditionUtils.throwException(partnerId, "合作商编号对应的存管类型不存在", EnumErrorCode.PARAMETER_ERROR);
        }
        return result;
    }
}
