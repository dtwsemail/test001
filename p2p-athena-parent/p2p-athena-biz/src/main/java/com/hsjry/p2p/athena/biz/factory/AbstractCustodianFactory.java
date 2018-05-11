package com.hsjry.p2p.athena.biz.factory;

import com.alibaba.druid.support.json.JSONUtils;
import com.hsjry.p2p.athena.common.constants.EnumBizStatus;
import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.utils.DateUtil;
import com.hsjry.p2p.athena.common.utils.JsonUtils;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.dal.dao.AthenaBizSerialDao;
import com.hsjry.p2p.athena.dal.dao.AthenaBizSerialExtDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerial;
import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerialExt;
import com.hsjry.p2p.athena.dal.integration.common.response.BaseBean;
import com.hsjry.p2p.athena.dal.integration.common.response.OpenAccountBean;
import com.hsjry.p2p.athena.dal.integration.common.response.SignInBean;
import com.hsjry.p2p.athena.dal.integration.service.SerialNoService;
import com.hsjry.p2p.athena.facade.request.BaseRequest;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public abstract class AbstractCustodianFactory {


    abstract OpenAccountBean openAccountForCompany(String partnerId, String partnerSerialNo, BaseRequest request);

    abstract SignInBean SignIn(String partnerId, String partnerSerialNo, BaseRequest request);

    abstract AthenaBizSerialDao getAthenaBizSerialDao();

    abstract AthenaBizSerialExtDao getAthenaBizSerialExtDao();


    private AthenaBizSerial addInitBizSerial(BaseRequest request) {
        AthenaBizSerial serial = new AthenaBizSerial();
        String partnerId = request.getPartnerId();

        serial.setPartnerId(partnerId);
        serial.setPartnerSerialNo(request.getPartnerSerialNo());
        serial.setStatus(EnumBizStatus.REQUEST_INIT.getCode());
        serial.setBizType(EnumBizType.find(request.getBizType()).getCode());
        serial.setCreateTime(DateUtil.getNow());
        int i = getAthenaBizSerialDao().insert(serial);
        PreconditionUtils.checkState(partnerId, i > 0, "添加流水失败", EnumErrorCode.DB_EXCEPTION);

        AthenaBizSerialExt ext = new AthenaBizSerialExt();
        ext.setId(SerialNoService.generateCommonSerivce());
        ext.setPartnerId(partnerId);
        ext.setPartnerSerialNo(request.getPartnerSerialNo());
        ext.setParameter(JsonUtils.toJSONString(request));
        int n = getAthenaBizSerialExtDao().insert(ext);
        PreconditionUtils.checkState(partnerId, n > 0, "添加流水失败", EnumErrorCode.DB_EXCEPTION);

        return serial;
    }

    private void updateBizSerial(String partnerId, String partnerSerialNo, EnumBizStatus originalStatus, EnumBizStatus status) {
        int i = getAthenaBizSerialDao().updateStatusByLock(partnerId, partnerSerialNo, originalStatus.getCode(), status.getCode());
        PreconditionUtils.checkState(partnerId, i > 0, "更新流水失败", EnumErrorCode.DB_EXCEPTION);
    }

    public BaseBean process(BaseRequest request) {
        BaseBean result = null;
        String partnerId = request.getPartnerId();
        String partnerSerialNo = request.getPartnerSerialNo();
        EnumBizType bizType = EnumBizType.find(request.getBizType());

        //新增业务流水
        addInitBizSerial(request);

        //业务处理
        switch (bizType) {
            case TEST:
                break;
            case SINGN_IN:
                result = this.SignIn(partnerId, partnerSerialNo, request);
                break;
            case OPEAN_ACCOUNT_FOR_COMPANY:
                result = this.openAccountForCompany(partnerId, partnerSerialNo, request);
                break;
            default:
                PreconditionUtils.throwException(partnerId, "业务类型暂不支持", EnumErrorCode.PARAMETER_ERROR);
        }

        //修改业务流水状态
        updateBizSerial(partnerId, partnerSerialNo, EnumBizStatus.REQUEST_INIT, EnumBizStatus.REQUEST_SUCCESS);

        return result;
    }
}
