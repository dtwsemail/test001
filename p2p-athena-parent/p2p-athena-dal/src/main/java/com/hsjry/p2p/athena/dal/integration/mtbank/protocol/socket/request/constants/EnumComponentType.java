package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element.ReturnResultElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.element.MessageHeaderElement;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlComposite;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public enum EnumComponentType {

    //-- top head
    TOP("MsgText", "消息体", true, Object.class),

    //---7.2.2　服务商签到(54901)
    MessageHeader("MsgHdr","消息头",true,MessageHeaderElement.class),
    Digest("Dgst","摘要",false,String.class),
    ReturnResult("Rst", "返回结果", true, ReturnResultElement.class),

    //------8.1　消息头（MessgeHeader）
    Version("Ver", "版本", true, String.class),
    SystemType("SysType", "应用系统类型", true, EnumSystemType.class),
    InstructionCode("InstrCd", "业务功能码", true, EnumInstructionCode.class),
    TradeSource("TradSrc", "交易发起方", true, EnumInstitutionType.class),
    ServiceInstitution("SvInst", "服务商机构信息", true, XmlComposite.class),
    BankInstitution("BkInst", "银行机构信息", true, XmlComposite.class),
    CreateDate("Date", "发生日期", false, String.class),
    CreateTime("Time", "发生时间", false, String.class),
    RequestReference("RqRef ", "请求流水号", true, String.class),
//    LastFragment("LstFrag", "最后分片标志"),

    //8.2　返回结果（ReturnResult）
    Code("Code","返回码",true,EnumReturnCode.class),
    Info("Info","返回信息",false,String.class),



        //8.3　流水号(Reference)
    Reference("Ref", "流水号", true, String.class),
    RefrenceIssureType("IssrType", "流水号发布者类型", false, EnumInstitutionType.class),
    ReferenceIssure("RefIssr", "发布者", false, String.class),


    //----8.4　机构信息（Institution）
    InstitutionType("InstType", "机构类型", false, EnumInstitutionType.class),
    InstitutionIdentifier("InstId", "机构标识", false, String.class),
    InstitutionName("InstNm", "机构名称", false, String.class),
    BranchIdentifier("BrchId", "分支机构编码", false, String.class),
    BranchName("BrchNm", "分支机构名称", false, String.class),
    SubBranchIdentifier("SubBrchId", "网点号", false, String.class),
    SubBranchName("SubBrchNm", "网点名称", false, String.class),;


    private String code;
    private String description;
    //字段类型
    private Class clazz;
    //是否允许为空
    private Boolean notEmptyFlag;


    EnumComponentType(String code, String description, boolean notEmptyFlag, Class clazz) {
        this.code = code;
        this.description = description;
        this.notEmptyFlag = notEmptyFlag;
        this.clazz = clazz;
    }

    public static EnumComponentType find(String code) {
        for (EnumComponentType frs : EnumComponentType.values()) {
            if (frs.getCode().equals(code)) {
                return frs;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    public static final String LEFT_BRACKET = "<";
    public static final String RIGHT_BRACKET = ">";
    public static final String SLASH = "/";


    public String getStartTag() {
        return LEFT_BRACKET + getCode() + RIGHT_BRACKET;
    }

    public String getEndTag() {
        return LEFT_BRACKET + SLASH + getCode() + RIGHT_BRACKET;
    }
}
