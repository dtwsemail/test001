package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component;

import java.util.List;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
public interface XmlElement {

    String MESSAGE_HEADER_VERSION = "1.0";

    List<XmlComponent> getComponentList();
}
