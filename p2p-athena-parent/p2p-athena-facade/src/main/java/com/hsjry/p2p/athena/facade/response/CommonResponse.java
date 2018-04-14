package com.hsjry.p2p.athena.facade.response;

/**
 * Created by wangyf14377 on 2018/4/8.
 */
public class CommonResponse {

    private String returnObj; //返回信息
    private long time;//返回时间
    private String code;//返回代码
    private String message;//返回说明
    private String certSign;//验签


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
}
