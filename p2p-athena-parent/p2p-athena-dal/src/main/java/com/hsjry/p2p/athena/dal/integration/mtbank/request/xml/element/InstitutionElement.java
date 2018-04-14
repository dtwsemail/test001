package com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.element;

import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumComponentType;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumInstitutionType;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlComponent;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlLeaf;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyf14377 on 2018/4/12.
 */
public class InstitutionElement implements XmlElement {

    private EnumInstitutionType institutionType ;
    private String institutionIdentifier;
    private String institutionName;
    private String branchIdentifier;
    private String branchName;
    private String subBranchIdentifier;
    private String subBranchName;

    public EnumInstitutionType getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(EnumInstitutionType institutionType) {
        this.institutionType = institutionType;
    }

    public String getInstitutionIdentifier() {
        return institutionIdentifier;
    }

    public void setInstitutionIdentifier(String institutionIdentifier) {
        this.institutionIdentifier = institutionIdentifier;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getBranchIdentifier() {
        return branchIdentifier;
    }

    public void setBranchIdentifier(String branchIdentifier) {
        this.branchIdentifier = branchIdentifier;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSubBranchIdentifier() {
        return subBranchIdentifier;
    }

    public void setSubBranchIdentifier(String subBranchIdentifier) {
        this.subBranchIdentifier = subBranchIdentifier;
    }

    public String getSubBranchName() {
        return subBranchName;
    }

    public void setSubBranchName(String subBranchName) {
        this.subBranchName = subBranchName;
    }


    public List<XmlComponent> getComponentList() {
        InstitutionElement bean = this;
        List<XmlComponent> xmlComponentList = new ArrayList<XmlComponent>();
        if (bean.getInstitutionType() != null) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.InstitutionType, bean.getInstitutionType().getCode()));
        }
        if (!StringUtils.isBlank(bean.getInstitutionIdentifier())) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.InstitutionIdentifier, bean.getInstitutionIdentifier()));
        }
        if (!StringUtils.isBlank(bean.getInstitutionName())) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.InstitutionName, bean.getInstitutionName()));
        }
        if (!StringUtils.isBlank(bean.getBranchIdentifier())) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.BranchIdentifier, bean.getBranchIdentifier()));
        }
        if (!StringUtils.isBlank(bean.getBranchName())) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.BranchName, bean.getBranchName()));
        }
        if (!StringUtils.isBlank(bean.getSubBranchIdentifier())) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.SubBranchIdentifier, bean.getSubBranchIdentifier()));
        }
        if (!StringUtils.isBlank(bean.getSubBranchName())) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.SubBranchName, bean.getSubBranchName()));
        }
        return xmlComponentList;
    }
}
