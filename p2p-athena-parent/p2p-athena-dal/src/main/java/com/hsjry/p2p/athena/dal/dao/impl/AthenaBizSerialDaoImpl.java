package com.hsjry.p2p.athena.dal.dao.impl;

import com.hsjry.p2p.athena.dal.dao.AthenaBizSerialDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerial;
import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerialExample;
import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerialKey;
import com.hsjry.p2p.athena.dal.dao.service.AthenaBizSerialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
@Repository
public class AthenaBizSerialDaoImpl implements AthenaBizSerialDao {

    @Autowired
    private AthenaBizSerialMapper athenaBizSerialMapper;

    @Override
    public int insert(AthenaBizSerial o) {
        return o == null ? 0 : athenaBizSerialMapper.insert(o);
    }

    @Override
    public int updateStatusByLock(String partnerId, String partnerSerialNo, String orginalStatus, String status){
        AthenaBizSerialExample example = new AthenaBizSerialExample();
        example.createCriteria().andPartnerIdEqualTo(partnerId).andPartnerSerialNoEqualTo(partnerSerialNo).andStatusEqualTo(orginalStatus);

        AthenaBizSerial record = new AthenaBizSerial();
        record.setStatus(status);
        return athenaBizSerialMapper.updateByExampleSelective(record,example);
    }
}
