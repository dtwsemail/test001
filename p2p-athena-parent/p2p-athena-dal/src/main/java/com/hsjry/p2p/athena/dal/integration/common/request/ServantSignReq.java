package com.hsjry.p2p.athena.dal.integration.common.request;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.MTRequest;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.ServantSignXmlReq;

/**
 * 签到请求
 */
@Deprecated
public class ServantSignReq implements MTRequest {

    private  String serialNo;//签到流水号
    private  String servantCode;//服务商代码
    private  String servantName;//服务商姓名
    private  String bankCode;//签约银行代码
    private  String bankName;//签约银行名字

    public ServantSignReq() {

    }
    // 明泰快捷构造函数
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


    public ServantSignXmlReq getMTXmlBean(){
        ServantSignXmlReq bean = ServantSignXmlReq.generate(this.serialNo, this.servantCode, this.servantName, this.getBankCode(), this.bankName);
        return bean;
    }
}
