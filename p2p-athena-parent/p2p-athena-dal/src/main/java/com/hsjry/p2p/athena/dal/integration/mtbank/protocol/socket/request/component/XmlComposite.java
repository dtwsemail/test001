package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component;

import com.hsjry.p2p.athena.common.constants.Constants;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumComponentType;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public class XmlComposite extends XmlComponent {

    private List<XmlComponent> xmlComponentList;

    public List<XmlComponent> getXmlComponentList() {
        return xmlComponentList;
    }

    public void setXmlComponentList(List<XmlComponent> xmlComponentList) {
        this.xmlComponentList = xmlComponentList;
    }

    public static XmlComposite generate(EnumComponentType type, List<XmlComponent> list) {
        XmlComposite left = new XmlComposite();
        left.setType(type);
        left.setXmlComponentList(list);
        return left;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (CollectionUtils.isEmpty(xmlComponentList)) {
            sb.append(Constants.EMPTY_STRING);
        } else {

            for (XmlComponent xmlComponent : xmlComponentList) {
                sb.append(xmlComponent.toString());
            }
        }
        return getType().getStartTag() + sb.toString() + getType().getEndTag();
    }


    public static void main(String[] args) {
        List<XmlComponent> xmlComponentList = new ArrayList<XmlComponent>();
        xmlComponentList.add(XmlLeaf.generate(EnumComponentType.Version, "1.0"));
        System.out.println(XmlComposite.generate(EnumComponentType.Version, xmlComponentList));
    }
}
