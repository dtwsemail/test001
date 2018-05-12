package com.hsjry.p2p.athena.dal.integration.service;

import com.hsjry.p2p.athena.common.constants.EnumBizType;

/**
 * Created by wangyf14377 on 2018/5/7.
 */
public interface RPCService {

    <REQUEST, RESPONSE> RESPONSE doService(String partnerId, String bizSerialNo, EnumBizType bizType, REQUEST request, ServiceProtocol<REQUEST, RESPONSE> protocol , Class retunClazz);

    <REQUEST, RESPONSE> RESPONSE doService(String partnerId, String bizSerialNo, EnumBizType bizType, REQUEST request, ServiceProtocol<REQUEST, RESPONSE> protocol,Class retunClazz, boolean isRecord);
}
