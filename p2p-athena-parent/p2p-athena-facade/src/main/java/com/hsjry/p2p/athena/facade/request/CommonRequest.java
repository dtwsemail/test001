package com.hsjry.p2p.athena.facade.request;

import java.io.Serializable;

/**
 * Created by wangyf14377 on 2018/4/8.
 */
public class CommonRequest implements Serializable {

    private String partnerId; //'合作商编号'
    private String partnerSerialNo; //'合作商流水'
    private String bizType;//业务类型
    private String parameter;//参数
    private String certSign; //验签参数

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerSerialNo() {
        return partnerSerialNo;
    }

    public void setPartnerSerialNo(String partnerSerialNo) {
        this.partnerSerialNo = partnerSerialNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getCertSign() {
        return certSign;
    }

    public void setCertSign(String certSign) {
        this.certSign = certSign;
    }
}
