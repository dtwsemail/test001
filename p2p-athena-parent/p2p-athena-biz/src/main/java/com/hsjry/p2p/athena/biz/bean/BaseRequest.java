package com.hsjry.p2p.athena.biz.bean;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public class BaseRequest {
    private String partnerId; //'合作商编号'
    private String partnerSerialNo; //'合作商流水'
    private String bizType;//业务类型
    private String parameter;//参数

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

    public BaseRequest(String partnerId, String partnerSerialNo, String bizType, String parameter) {
        this.partnerId = partnerId;
        this.partnerSerialNo = partnerSerialNo;
        this.bizType = bizType;
        this.parameter = parameter;
    }
}
