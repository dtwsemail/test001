package com.hsjry.p2p.athena.dal.integration.mtbank.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.dal.integration.common.utils.HsSocketClient;
import com.hsjry.p2p.athena.dal.integration.common.utils.XmlParser;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.component.XmlRequestBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.MTBaseRes;
import com.hsjry.p2p.athena.dal.integration.mtbank.utils.MTUtils;
import com.hsjry.p2p.athena.dal.integration.service.ServiceProtocol;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


/**
 * Created by wangyf14377 on 2018/4/14.
 */
@Service
public class MTSocketServiceImpl<REQUEST extends String, RESPONSE extends MTBaseRes> implements ServiceProtocol<REQUEST, RESPONSE> {

    private final static Log log = Log.get(MTSocketServiceImpl.class);

    private String ipAddress = "192.168.46.212";
    private int port = 8816;




    @Override
    public String doService(REQUEST bean) throws Exception {
        String result = null;
        HsSocketClient client = new HsSocketClient();
        try {
            client.setAddress(ipAddress);
            client.setPort(8816);
            client.init();
            client.connect();
            System.out.println("begin send=======");
            client.send(bean.getBytes("GBK"));
            System.out.println("begin receive =====");
            byte[] bytes = client.recv();
            System.out.println("*****");
            result = new String(bytes, "GB2312");
            System.out.println(result);
        } finally {
            try {
                if (client != null)
                    client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 判读远程调用是否成功
     *
     * @param result
     * @return
     */
    @Override
    public boolean checkIsSuccess(RESPONSE result) {
        return MTUtils.checkIsSuccess(result);
    }

    @Override
    public RESPONSE getResult(String result, Class<RESPONSE> returnClazz) {
        try {
            if(result!=null){
                JSONObject o = XmlParser.xml2Json(result);
                 return   o.toJavaObject(returnClazz);
            }
        } catch (Exception e) {
            log.error(e,"解析明泰返回报文出错");
        }
        return null;
    }
}
