package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request;

import com.hsjry.p2p.athena.common.utils.DateUtil;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumInstitutionType;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlRequestBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlComponent;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlComposite;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlLeaf;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumComponentType;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumInstructionCode;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element.InstitutionElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element.MessageHeaderElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element.ReferenceElement;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 民泰存管签到xml对象
 * Created by wangyf14377 on 2018/4/12.
 */
public class ServantSignXmlReq extends XmlRequestBean {

    private MessageHeaderElement messageHeader;
    private String digest;

    public MessageHeaderElement getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeaderElement messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public XmlComponent getComponent() {
        List<XmlComponent> xmlComponentList = new ArrayList<XmlComponent>();
        if (messageHeader != null) {
            xmlComponentList.add(XmlComposite.generate(EnumComponentType.MessageHeader, messageHeader.getComponentList()));
        }
        if (!StringUtils.isBlank(digest)) {
            xmlComponentList.add(XmlLeaf.generate(EnumComponentType.Digest, digest));
        }
        return XmlComposite.generate(EnumComponentType.TOP, xmlComponentList);
    }

    @Override
    public EnumInstructionCode getInstructionCode() {
        return EnumInstructionCode.SERVANT_SIGN;
    }


    public static ServantSignXmlReq generate(String serialNo, String servantCode, String servantName, String bankCode, String bankName){

        ServantSignXmlReq bean = new ServantSignXmlReq();
        MessageHeaderElement messageHeaderBean = new MessageHeaderElement();
        messageHeaderBean.setInstructionCode(EnumInstructionCode.SERVANT_SIGN);

        InstitutionElement servant = new InstitutionElement();
        servant.setInstitutionType(EnumInstitutionType.SERVANT);
        servant.setInstitutionIdentifier(servantCode);
        servant.setInstitutionName(servantName);
        messageHeaderBean.setServiceInstitution(servant);

        InstitutionElement institutionBean = new InstitutionElement();
        institutionBean.setInstitutionType(EnumInstitutionType.BANK);
        institutionBean.setInstitutionIdentifier(bankCode);
        institutionBean.setInstitutionName(bankName);
        messageHeaderBean.setBankInstitution(institutionBean);

        Date now = DateUtil.getNow();
        messageHeaderBean.setCreateDate(DateUtil.format(now, DateUtil.SIMPLE_DATE_FORMAT));
        messageHeaderBean.setCreateTime(DateUtil.format(now, DateUtil.SIMPLE_TIME_FORMAT));

        ReferenceElement e = new ReferenceElement();
        e.setReference(serialNo);
        messageHeaderBean.setRequestReference(e);

        bean.setMessageHeader(messageHeaderBean);

        return bean;
    }

    public static void main(String[] args) {
//        ServantSignXmlReq response = generate("20160921080000006887");
//        response.setDigest("abc");

//          <MsgText><MsgHdr><Ver>1.0</Ver><SysType>5</SysType><InstrCd>54901</InstrCd><TradSrc>0</TradSrc>
// <SvInst><InstType>0</InstType><InstId>20170001</InstId><InstNm>国家粮食局粮食交易协调中心</InstNm></SvInst>
// <BkInst><InstType>1</InstType><InstId>j</InstId><InstNm>农发行</InstNm></BkInst>
// <Date>20180414</Date><Time>030417</Time>
// <RqRef ><RefIssr></RefIssr></RqRef ></MsgHdr><Dgst>abc</Dgst></MsgText>

// /        <MsgText><MsgHdr><Ver>1.0</Ver><SysType>5</SysType><InstrCd>54901</InstrCd><TradSrc>0</TradSrc>
//<SvInst><InstType>0</InstType><InstId>20170001</InstId><InstNm>国家粮食局粮食交易协调中心</InstNm></SvInst>
// <BkInst><InstType>1</InstType><InstId>j</InstId><InstNm>农发行</InstNm></BkInst>
// <Date>20160921</Date><Time>080000</Time><RqRef>
// <Ref>20160921080000006887</Ref><IssrType></IssrType><RefIssr></RefIssr></RqRef><LstFrag></LstFrag></MsgHdr><Dgst></Dgst></MsgText>";

//        System.out.println(response.getRequestBody());
    }
}
