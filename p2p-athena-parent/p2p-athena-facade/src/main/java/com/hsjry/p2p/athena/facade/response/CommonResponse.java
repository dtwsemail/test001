package com.hsjry.p2p.athena.facade.response;

import java.io.Serializable;

/**
 * Created by wangyf14377 on 2018/4/8.
 */
public class CommonResponse implements Serializable {

    private String returnObj; //返回信息
    private long dealTime;//处理时间
    private long time;//返回时间点
    private String code;//返回代码
    private String message;//返回说明
    private String certSign;//验签
    private String partnerId;//租户号
    private String partnerSerialNo;//原流水号


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



    public String getReturnObj() {
        return returnObj;
    }

    public void setReturnObj(String returnObj) {
        this.returnObj = returnObj;
    }

    public String getCertSign() {
        return certSign;
    }

    public void setCertSign(String certSign) {
        this.certSign = certSign;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getDealTime() {
        return dealTime;
    }

    public void setDealTime(long dealTime) {
        this.dealTime = dealTime;
    }
}
