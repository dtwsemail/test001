package com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.element;

import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumComponentType;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumInstitutionType;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumInstructionCode;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumSystemType;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlComponent;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlComposite;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlLeaf;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyf14377 on 2018/4/12.
 */
public class MessageHeaderElement implements XmlElement {

    private String version = MESSAGE_HEADER_VERSION;
    private EnumSystemType systemType = EnumSystemType.REGULATORY_SYSTEM;
    private EnumInstructionCode instructionCode;
    private EnumInstitutionType tradeSource = EnumInstitutionType.SERVANT;
    private InstitutionElement serviceInstitution;
    private InstitutionElement bankInstitution;
    private String createDate;
    private String createTime;
    private ReferenceElement requestReference;
    private String lastFragment;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public EnumSystemType getSystemType() {
        return systemType;
    }

    public void setSystemType(EnumSystemType systemType) {
        this.systemType = systemType;
    }

    public EnumInstructionCode getInstructionCode() {
        return instructionCode;
    }

    public void setInstructionCode(EnumInstructionCode instructionCode) {
        this.instructionCode = instructionCode;
    }

    public EnumInstitutionType getTradeSource() {
        return tradeSource;
    }

    public void setTradeSource(EnumInstitutionType tradeSource) {
        this.tradeSource = tradeSource;
    }

    public InstitutionElement getServiceInstitution() {
        return serviceInstitution;
    }

    public void setServiceInstitution(InstitutionElement serviceInstitution) {
        this.serviceInstitution = serviceInstitution;
    }

    public InstitutionElement getBankInstitution() {
        return bankInstitution;
    }

    public void setBankInstitution(InstitutionElement bankInstitution) {
        this.bankInstitution = bankInstitution;
    }

    public ReferenceElement getRequestReference() {
        return requestReference;
    }

    public void setRequestReference(ReferenceElement requestReference) {
        this.requestReference = requestReference;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getLastFragment() {
        return lastFragment;
    }

    public void setLastFragment(String lastFragment) {
        this.lastFragment = lastFragment;
    }

    public List<XmlComponent> getComponentList() {
        MessageHeaderElement bean = this;
        List<XmlComponent> list = new ArrayList<XmlComponent>();
        if (!StringUtils.isBlank(bean.getVersion())) {
            list.add(XmlLeaf.generate(EnumComponentType.Version, bean.getVersion()));
        }
        if (bean.getSystemType() != null) {
            list.add(XmlLeaf.generate(EnumComponentType.SystemType, bean.getSystemType().getCode()));
        }
        if (bean.getInstructionCode() != null) {
            list.add(XmlLeaf.generate(EnumComponentType.InstructionCode, bean.getInstructionCode().getCode()));
        }
        if (bean.getTradeSource() != null) {
            list.add(XmlLeaf.generate(EnumComponentType.TradeSource, bean.getTradeSource().getCode()));
        }
        if (bean.getServiceInstitution() != null) {
            list.add(XmlComposite.generate(EnumComponentType.ServiceInstitution, bean.getServiceInstitution().getComponentList()));
        }
        if (bean.getBankInstitution() != null) {
            list.add(XmlComposite.generate(EnumComponentType.BankInstitution, bean.getBankInstitution().getComponentList()));
        }
        if (!StringUtils.isBlank(bean.getCreateDate())) {
            list.add(XmlLeaf.generate(EnumComponentType.CreateDate, bean.getCreateDate()));
        }
        if (!StringUtils.isBlank(bean.getCreateTime())) {
            list.add(XmlLeaf.generate(EnumComponentType.CreateTime, bean.getCreateTime()));
        }
        if (bean.getRequestReference() != null) {
            list.add(XmlComposite.generate(EnumComponentType.RequestReference, bean.getRequestReference().getComponentList()));
        }
//        if (!StringUtils.isBlank(bean.getLastFragment())) {
//            list.add(XmlLeaf.generate(EnumComponentType.LastFragment, bean.getLastFragment()));
//        }
        return list;
    }
}
