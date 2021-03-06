package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumComponentType;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public abstract class XmlComponent {

    private EnumComponentType type;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public EnumComponentType getType() {
        return type;
    }

    public void setType(EnumComponentType type) {
        this.type = type;
    }


}
