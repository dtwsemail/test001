package com.hsjry.p2p.athena.dal.dao.impl;

import com.hsjry.p2p.athena.dal.dao.AthenaRpcLogDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaRpcLog;
import com.hsjry.p2p.athena.dal.dao.service.AthenaRpcLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangyf14377 on 2018/5/7.
 */
@Repository
public class AthenaRpcLogDaoImpl implements AthenaRpcLogDao {

    @Autowired
    private AthenaRpcLogMapper athenaRpcLogDaoMapper;

    @Override
    public int insert(AthenaRpcLog log) {
        return athenaRpcLogDaoMapper.insert(log);
    }
}
