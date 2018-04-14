package com.hsjry.p2p.athena.dal.integration.common.service.impl;

import com.hsjry.p2p.athena.dal.integration.service.SerialNoService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by wangyf14377 on 2018/4/14.
 */
@Service
public class SerialNoServiceImpl implements SerialNoService {


    @Override
    public String generateCommonSerivce(){
        return UUID.randomUUID().toString();
    }
}
