package com.hsjry.p2p.athena.dal.integration.common.request;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.MTRequest;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlRequestBean;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
@Deprecated
public class OpenAccountForCompanyReq implements MTRequest {
    private String subacctno;//          资金账号	String	20	★	会员资金账号
    private String currcode;//         币种	String	1	★	详见数据字典D3
    private String custno;//          企业代码	String	20	★	服务商会员号，不能重复
    private String custname;//     企业名称	String	140	★	工商登记的企业全称
    private String custaccount;//         收款银行账号	String	32	★	收款银行账号
    private String openbankcode;//     银行开户行号	String	32	★	收款银行行号
    private String openbankname;//     银行开户行名	String	128	★	收款银行行名
    private String bankflag;// 本他行标志	String	1	★	详见数据字典D7
    private String certtype;// 企业证件类型	String	1	★	详见数据字典D1
    private String certno;//     企业证件号码	String	20	★	企业证件类型对应的证件号码
    private String legalrealname;//	        法人代表	String	20	★	法定代表人
    private String legalcerttype;//     	法人证件类型	String	1	★	详见数据字典D2
    private String legalcertno;// 	法人证件号码	String	20	★	固定为身份证号码
    private String agentname;//     经办人姓名	String	20	★
    private String agentcerttype;//      15		经办人证件类型	String	1	★	详见数据字典 D2
    private String agentcertno;//         经办人证件号码	String	20	★	固定为身份证号码
    private String agentmobileno;//	        经办人手机号码	String	11	★

    public String getSubacctno() {
        return subacctno;
    }

    public void setSubacctno(String subacctno) {
        this.subacctno = subacctno;
    }

    public String getCurrcode() {
        return currcode;
    }

    public void setCurrcode(String currcode) {
        this.currcode = currcode;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustaccount() {
        return custaccount;
    }

    public void setCustaccount(String custaccount) {
        this.custaccount = custaccount;
    }

    public String getOpenbankcode() {
        return openbankcode;
    }

    public void setOpenbankcode(String openbankcode) {
        this.openbankcode = openbankcode;
    }

    public String getOpenbankname() {
        return openbankname;
    }

    public void setOpenbankname(String openbankname) {
        this.openbankname = openbankname;
    }

    public String getBankflag() {
        return bankflag;
    }

    public void setBankflag(String bankflag) {
        this.bankflag = bankflag;
    }

    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }

    public String getCertno() {
        return certno;
    }

    public void setCertno(String certno) {
        this.certno = certno;
    }

    public String getLegalrealname() {
        return legalrealname;
    }

    public void setLegalrealname(String legalrealname) {
        this.legalrealname = legalrealname;
    }

    public String getLegalcerttype() {
        return legalcerttype;
    }

    public void setLegalcerttype(String legalcerttype) {
        this.legalcerttype = legalcerttype;
    }

    public String getLegalcertno() {
        return legalcertno;
    }

    public void setLegalcertno(String legalcertno) {
        this.legalcertno = legalcertno;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getAgentcerttype() {
        return agentcerttype;
    }

    public void setAgentcerttype(String agentcerttype) {
        this.agentcerttype = agentcerttype;
    }

    public String getAgentcertno() {
        return agentcertno;
    }

    public void setAgentcertno(String agentcertno) {
        this.agentcertno = agentcertno;
    }

    public String getAgentmobileno() {
        return agentmobileno;
    }

    public void setAgentmobileno(String agentmobileno) {
        this.agentmobileno = agentmobileno;
    }

    @Override
    public XmlRequestBean getMTXmlBean() {
        return null;
    }
}
