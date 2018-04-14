package com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component;

import com.hsjry.p2p.athena.common.constants.Constants;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumComponentType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public class XmlLeaf extends XmlComponent {

    public XmlLeaf(EnumComponentType type, String value) {
        setType(type);
        setValue(value);
    }


    public static XmlComponent generate(EnumComponentType type, String value) {
        if (type == null) {
            return null;
        }
        return new XmlLeaf(type, value);
    }

    @Override
    public String toString() {
        String value = StringUtils.isBlank(getValue()) ? Constants.EMPTY_STRING : getValue();
        return getType().getStartTag() + value + getType().getEndTag();
    }

    public static void main(String[] args) {
        System.out.println(XmlLeaf.generate(EnumComponentType.Version, "1.0"));
    }
}
