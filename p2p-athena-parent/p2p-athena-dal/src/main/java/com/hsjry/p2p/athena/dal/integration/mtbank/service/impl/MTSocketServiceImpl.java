package com.hsjry.p2p.athena.dal.integration.mtbank.service.impl;

import com.hsjry.p2p.athena.dal.integration.common.utils.HsSocketClient;
import com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.component.XmlRequestBean;
import com.hsjry.p2p.athena.dal.integration.mtbank.service.MTSocketSerivce;
import org.springframework.stereotype.Service;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
@Service
public class MTSocketServiceImpl implements MTSocketSerivce {

    private String ipAddress = "192.168.46.212";
    private int port = 8816;

    @Override
    public void doService(XmlRequestBean bean) {
        HsSocketClient client = new HsSocketClient();
        try {
            client.setAddress(ipAddress);
            client.setPort(8816);
            client.init();
            client.connect();
            System.out.println("begin send=======");
            client.send(bean.getRequest().getBytes("GBK"));
            System.out.println("begin receive =====");
            byte[] bytes = client.recv();
            System.out.println("*****");
            System.out.println(new String(bytes, "GB2312"));
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
}
