package com.hsjry.p2p.athena.dal.integration.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.ServantSignRes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by wangyf14377 on 2018/4/13.
 */
public class TestScoketInfo {
    public static final String servant_code = "20170001";
    //    1字节报文性质	3字节包头长度	5字节包体长度	8字节服务商代码	5字节交易码	3字节加密标志	32字节MAC值	XML数据报文

    public static String toFixedLengthWithZero(String text, int fixedLength) {
        StringBuffer sb = new StringBuffer();
        int length = text.length();
        for (int i = length; i < fixedLength; i++) {
            sb.append("0");
        }
        return sb.append(text).toString();

    }

    public static String getInfo(String body) {
        StringBuffer sb = new StringBuffer();
        sb.append("X");
        sb.append("057");
//        sb.append(toFixedLengthWithZero(body.length()+"", 5));
        sb.append("00658");
        sb.append(servant_code);
        sb.append("54901");
        sb.append("000");
        sb.append(toFixedLengthWithZero("0", 32));
        sb.append(body);
        return sb.toString();
    }

    public static void main2(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" +
                "<MsgText><MsgHdr><Ver>1.0</Ver><SysType>5</SysType><InstrCd>54901</InstrCd><TradSrc>0</TradSrc><SvInst><InstType>0</InstType><InstId>20170001</InstId><InstNm>国家粮食局粮食交易协调中心</InstNm><BrchId></BrchId><BrchNm></BrchNm><SubBrchId></SubBrchId><SubBrchNm></SubBrchNm></SvInst><BkInst><InstType>1</InstType><InstId>j</InstId><InstNm>农发行</InstNm><BrchId></BrchId><BrchNm></BrchNm><SubBrchId></SubBrchId><SubBrchNm></SubBrchNm></BkInst><Date>20160921</Date><Time>080000</Time><RqRef><Ref>20160921080000006887</Ref><IssrType></IssrType><RefIssr></RefIssr></RqRef><LstFrag></LstFrag></MsgHdr><Dgst></Dgst></MsgText>";
        try {
            System.out.println(xml.getBytes("utf-8").length);
            xml = new String(xml.getBytes(), "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(xml.length());
        System.out.println(xml.codePointCount(0, xml.length()));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String xml = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" +
                "<MsgText><MsgHdr><Ver>1.0</Ver><SysType>5</SysType><InstrCd>54901</InstrCd><TradSrc>0</TradSrc><SvInst><InstType>0</InstType><InstId>20170001</InstId><InstNm>国家粮食局粮食交易协调中心</InstNm><BrchId></BrchId><BrchNm></BrchNm><SubBrchId></SubBrchId><SubBrchNm></SubBrchNm></SvInst><BkInst><InstType>1</InstType><InstId>j</InstId><InstNm>农发行</InstNm><BrchId></BrchId><BrchNm></BrchNm><SubBrchId></SubBrchId><SubBrchNm></SubBrchNm></BkInst><Date>20160921</Date><Time>080000</Time><RqRef><Ref>20160921080000006887</Ref><IssrType></IssrType><RefIssr></RefIssr></RqRef><LstFrag></LstFrag></MsgHdr><Dgst></Dgst></MsgText>";

        String s = getInfo(xml);
        System.out.println("请求：" + s);
        HsSocketClient client = new HsSocketClient();
        try {
            client.setAddress("192.168.46.212");
            client.setPort(8816);
            client.init();
            client.connect();
            System.out.println("begin send=======");
            client.send(s.getBytes("GBK"));
            System.out.println("begin receive =====");
            byte[] bytes = client.recv();
            System.out.println("*****");
            String r = new String(bytes, "GB2312");
            JSONObject o = XmlParser.xml2Json(r);
            System.out.println(o.toJavaObject(ServantSignRes.class));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null)
                    client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public String getMac() {
        String address = null;
        try {
            String command = "cmd.exe /c ipconfig /all";
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("Physical Address") > 0) {
                    int index = line.indexOf(":");
                    index += 2;
                    address = line.substring(index);
                    break;
                }
            }
            br.close();
            System.out.println(address);
        } catch (Exception e) {
        }
        return address;
    }
}
