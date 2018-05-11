package com.hsjry.p2p.athena.dal.dao.impl;

import com.hsjry.p2p.athena.dal.dao.AthenaBizSerialExtDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaBizSerialExt;
import com.hsjry.p2p.athena.dal.dao.service.AthenaBizSerialExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
@Repository
public class AthenaBizSerialExtDaoImpl implements AthenaBizSerialExtDao {

    @Autowired
    private AthenaBizSerialExtMapper mapper;

    @Override
    public int insert(AthenaBizSerialExt ext) {
        return ext == null ? 0 : mapper.insert(ext);
    }
}
