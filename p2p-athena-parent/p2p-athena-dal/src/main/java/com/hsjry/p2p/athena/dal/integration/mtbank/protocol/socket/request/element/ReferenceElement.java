package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlLeaf;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumComponentType;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumInstitutionType;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlComponent;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyf14377 on 2018/4/12.
 */
public class ReferenceElement implements XmlElement {
    private String reference;
    private EnumInstitutionType refrenceIssureType ;
    private String referenceIssure;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public EnumInstitutionType getRefrenceIssureType() {
        return refrenceIssureType;
    }

    public void setRefrenceIssureType(EnumInstitutionType refrenceIssureType) {
        this.refrenceIssureType = refrenceIssureType;
    }

    public String getReferenceIssure() {
        return referenceIssure;
    }

    public void setReferenceIssure(String referenceIssure) {
        this.referenceIssure = referenceIssure;
    }

    public List<XmlComponent> getComponentList() {

        List<XmlComponent> list = new ArrayList<XmlComponent>();
        if (!StringUtils.isBlank(reference)) {
            list.add(XmlLeaf.generate(EnumComponentType.Reference, reference));
        }
        if (refrenceIssureType != null) {
            list.add(XmlLeaf.generate(EnumComponentType.RefrenceIssureType, refrenceIssureType.getCode()));
        }
        if (!StringUtils.isBlank(referenceIssure)) {
            list.add(XmlLeaf.generate(EnumComponentType.ReferenceIssure, referenceIssure));
        }
        return list;
    }

}
