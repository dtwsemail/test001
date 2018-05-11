package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.element;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
public class MessageHeader {
    private String Ver;
    private String Time;
    private String TradSrc;
    private String Date;
    private RequestReference RqRef;

    public String getVer() {
        return Ver;
    }

    public void setVer(String ver) {
        Ver = ver;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTradSrc() {
        return TradSrc;
    }

    public void setTradSrc(String tradSrc) {
        TradSrc = tradSrc;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public RequestReference getRqRef() {
        return RqRef;
    }

    public void setRqRef(RequestReference rqRef) {
        RqRef = rqRef;
    }
}
