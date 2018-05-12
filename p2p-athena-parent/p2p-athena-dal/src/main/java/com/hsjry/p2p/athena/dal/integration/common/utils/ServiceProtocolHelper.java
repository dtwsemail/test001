package com.hsjry.p2p.athena.dal.integration.common.utils;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.MTBaseRes;
import com.hsjry.p2p.athena.dal.integration.mtbank.service.impl.MTSocketServiceProtocolImpl;
import com.hsjry.p2p.athena.dal.integration.mtbank.service.impl.MockMTSocketServiceProtocolImpl;
import com.hsjry.p2p.athena.dal.integration.service.ServiceProtocol;
import org.springframework.stereotype.Service;

/**
 * Created by wangyf14377 on 2018/5/9.
 */
@Service
public class ServiceProtocolHelper {

    private boolean isMock = true;

    //TODO:考虑是否可以做缓存
    public  <Q extends MTBaseRes> ServiceProtocol<String, Q> getMTSockeProtocol() {

        ServiceProtocol<String, Q> result = null;
        if(isMock){
            result = new MockMTSocketServiceProtocolImpl<String, Q>();
        }else{
           result = new MTSocketServiceProtocolImpl<String, Q>();
        }
        return result;
    }


}
