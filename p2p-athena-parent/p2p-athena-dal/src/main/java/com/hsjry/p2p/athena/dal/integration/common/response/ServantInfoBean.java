package com.hsjry.p2p.athena.dal.integration.common.response;

import com.hsjry.p2p.athena.common.constants.EnumCustodianType;

/**
 * 服务商信息
 * Created by wangyf14377 on 2018/5/9.
 */
public class ServantInfoBean extends BaseBean {

    private String partnerId;
    private String partnerCode;
    private String partnerName;
    private String bankCode;
    private String bankName;
    private EnumCustodianType custodianType;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public EnumCustodianType getCustodianType() {
        return custodianType;
    }

    public void setCustodianType(EnumCustodianType custodianType) {
        this.custodianType = custodianType;
    }
}
