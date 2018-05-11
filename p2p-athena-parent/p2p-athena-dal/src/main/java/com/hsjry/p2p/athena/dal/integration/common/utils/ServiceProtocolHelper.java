package com.hsjry.p2p.athena.dal.integration.common.utils;

import com.hsjry.p2p.athena.dal.integration.common.response.BaseBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlRequestBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.MTBaseRes;
import com.hsjry.p2p.athena.dal.integration.mtbank.service.impl.MTSocketServiceImpl;
import com.hsjry.p2p.athena.dal.integration.service.ServiceProtocol;
import org.springframework.stereotype.Service;

/**
 * Created by wangyf14377 on 2018/5/9.
 */
@Service
public class ServiceProtocolHelper {


    //TODO:考虑是否可以做缓存
    public  <Q extends MTBaseRes> ServiceProtocol<XmlRequestBean, Q> getMTSockeProtocol() {
        ServiceProtocol<XmlRequestBean, Q> result = new MTSocketServiceImpl<XmlRequestBean, Q>();
        return result;
    }


}
