package com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component;

import com.hsjry.p2p.athena.common.constants.Constants;
import com.hsjry.p2p.athena.dal.integration.mtbank.ConfigConstants;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants.EnumInstructionCode;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
public abstract class XmlRequestBean {

    private final static String XML_HEADER = "<?xml version=\"1.0\" encoding=\"GB2312\"?>";
    public static final String REQUEST_HEADER_LENGTH = "057";
    public static final String XML = "X";
    public static final String ZERO_STRING = "0";
    public static final String CHARSET_GBK = "gbk";

    public abstract XmlComponent getComponent();

    public abstract EnumInstructionCode getInstructionCode();

    public String getRequestBody() {

        String result = XML_HEADER;
        XmlComponent c = getComponent();
        if (c != null) {
            result = XML_HEADER + c.toString();
        }
        return result;
    }

    public String getRequest() throws Exception {
        String body = getRequestBody();
        StringBuffer request = new StringBuffer();
        request.append(XML);//xml
        request.append(REQUEST_HEADER_LENGTH);//请求头长度
        request.append(toFixedLengthWithZero(body.getBytes(CHARSET_GBK).length + "", 5));//请求体长度
        request.append(getInstructionCode());//服务号
        request.append(ConfigConstants.ENCRY_TYPE);//加密方式
        request.append(toFixedLengthWithZero("0", 32));//mac
        request.append(body);//请求体
        return request.toString();
    }


    public String toFixedLengthWithZero(String text, int fixedLength) {

        if (fixedLength < 1) {
            return Constants.EMPTY_STRING;
        }

        if (text == null) {
            text = Constants.EMPTY_STRING;
        }

        if (text.length() > fixedLength) {
            return text.substring(0, fixedLength);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = text.length(); i < fixedLength; i++) {
            sb.append(ZERO_STRING);
        }
        return sb.append(text).toString();
    }

}
