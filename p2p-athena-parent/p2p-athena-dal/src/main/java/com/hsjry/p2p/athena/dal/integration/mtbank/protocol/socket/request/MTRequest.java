package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlRequestBean;

/**
 * Created by wangyf14377 on 2018/5/9.
 */
public interface MTRequest {

    /**
     * 将通用request对象转换成民泰xml对象
     * @return
     */
    public XmlRequestBean getMTXmlBean();



}
