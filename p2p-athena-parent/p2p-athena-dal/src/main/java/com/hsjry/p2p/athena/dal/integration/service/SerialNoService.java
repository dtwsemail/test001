package com.hsjry.p2p.athena.dal.integration.service;

import java.util.UUID;

/**
 * 生成流水号服务
 * Created by wangyf14377 on 2018/4/14.
 */
public abstract class SerialNoService {


    public static String generateCommonSerivce() {
            return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(generateCommonSerivce());
    }
}
