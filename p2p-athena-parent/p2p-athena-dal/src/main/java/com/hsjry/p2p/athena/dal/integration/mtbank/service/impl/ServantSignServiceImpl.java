package com.hsjry.p2p.athena.dal.integration.mtbank.service.impl;

import com.hsjry.p2p.athena.common.constants.Constants;
import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.dal.integration.common.response.ServantInfoBean;
import com.hsjry.p2p.athena.dal.integration.common.response.SignInBean;
import com.hsjry.p2p.athena.dal.integration.common.utils.ServiceProtocolHelper;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.ServantSignXmlReq;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlRequestBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.ServantSignRes;
import com.hsjry.p2p.athena.dal.integration.mtbank.utils.MTUtils;
import com.hsjry.p2p.athena.dal.integration.service.ConfigInfoService;
import com.hsjry.p2p.athena.dal.integration.service.RPCService;
import com.hsjry.p2p.athena.dal.integration.service.ServantSignService;
import com.hsjry.p2p.athena.dal.integration.service.ServiceProtocol;
import com.hsjry.p2p.athena.facade.request.SignInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商户签到
 * Created by wangyf14377 on 2018/4/14.
 */
@Service("MTServantSignService")
public class ServantSignServiceImpl implements ServantSignService {

    @Autowired
    private ConfigInfoService configInfoService;
    @Autowired
    private ServiceProtocolHelper helper;
    @Autowired
    private RPCService rpcService;

    @Override
    public SignInBean doService(SignInRequest request) {
        String partnerId = request.getPartnerId();
        String partnerSerialNo = request.getPartnerSerialNo();
        ServantInfoBean info = configInfoService.getServantInfoBean(partnerId);
        ServantSignXmlReq bean = ServantSignXmlReq.generate(partnerSerialNo, info.getPartnerCode(), info.getPartnerName(), info.getBankCode(), info.getBankName());
        ServiceProtocol<XmlRequestBean, ServantSignRes> mtSockeProtocol = helper.getMTSockeProtocol();
        ServantSignRes servantSignRes = rpcService.doService(partnerId, partnerSerialNo, EnumBizType.SINGN_IN, bean, mtSockeProtocol, ServantSignRes.class);
        return convert(partnerId, servantSignRes);
    }


    public SignInBean convert(String partnerId, ServantSignRes servantSignRes) {
        PreconditionUtils.checkNotNull(partnerId,servantSignRes, "托管返回信息错误", EnumErrorCode.SERVER_ERROR);
        boolean isSuccess = MTUtils.checkIsSuccess(servantSignRes);
        String errorInfo = servantSignRes.getRst() == null ? Constants.EMPTY_STRING : servantSignRes.getRst().getInfo();
        PreconditionUtils.checkState(partnerId, isSuccess, "商户签到失败:" + errorInfo, EnumErrorCode.SERVER_ERROR);
        SignInBean bean = new SignInBean();
        //向bean对象里传送biz需要的字段
        return bean;
    }


}
