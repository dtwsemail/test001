package com.hsjry.p2p.athena.dal.integration.mtbank.service;

import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlRequestBean;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
public interface MTSocketSerivce {
    void doService(XmlRequestBean bean);
}
