package com.hsjry.p2p.athena.biz.factory;

import com.hsjry.p2p.athena.biz.bean.BaseBean;
import com.hsjry.p2p.athena.biz.bean.BaseRequest;
import com.hsjry.p2p.athena.biz.bean.OpenAccountBean;
import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public abstract class AbstractCustodianFactory {


    abstract OpenAccountBean openAccountForCompany(BaseRequest request);


    public BaseBean process(BaseRequest request) {
        BaseBean result = null;
        String partnerId = request.getPartnerId();
        EnumBizType bizType = EnumBizType.find(request.getBizType());
        switch (bizType) {
            case TEST:
                break;
            case OPEAN_ACCOUNT_FOR_COMPANY:
                result = this.openAccountForCompany(request);
                break;
            default:
                PreconditionUtils.throwException(partnerId, "业务类型暂不支持", EnumErrorCode.PARAMETER_ERROR);
        }
        return result;
    }
}
