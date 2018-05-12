package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlComponent;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlLeaf;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumComponentType;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumReturnCode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyf14377 on 2018/5/9.
 */
public class ReturnResultElement implements XmlElement {

    private EnumReturnCode code;
    private String info;

    @Override
    public List<XmlComponent> getComponentList() {
        List<XmlComponent> list = new ArrayList<XmlComponent>();
        if (code != null) {
            list.add(XmlLeaf.generate(EnumComponentType.Code, code.getCode()));
        }
        if (!StringUtils.isBlank(info)) {
            list.add(XmlLeaf.generate(EnumComponentType.Info, info));
        }
        return list;
    }
}
