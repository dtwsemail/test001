package com.hsjry.p2p.athena.dal.dao;

import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerial;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
public interface AthenaBizSerialDao {
    int insert(AthenaBizSerial o);

    int updateStatusByLock(String partnerId, String partnerSerialNo, String orginalStatus, String status);
}
