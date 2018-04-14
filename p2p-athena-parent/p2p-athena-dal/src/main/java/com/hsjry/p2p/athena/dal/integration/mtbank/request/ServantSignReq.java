package com.hsjry.p2p.athena.dal.integration.mtbank.request;

public class ServantSignReq {
    private final String serialNo;
    private final String servantCode;
    private final String servantName;
    private final String bankCode;
    private final String bankName;

    public ServantSignReq(String serialNo, String servantCode, String servantName, String bankCode, String bankName) {
        this.serialNo = serialNo;
        this.servantCode = servantCode;
        this.servantName = servantName;
        this.bankCode = bankCode;
        this.bankName = bankName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public String getServantCode() {
        return servantCode;
    }

    public String getServantName() {
        return servantName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getBankName() {
        return bankName;
    }
}
