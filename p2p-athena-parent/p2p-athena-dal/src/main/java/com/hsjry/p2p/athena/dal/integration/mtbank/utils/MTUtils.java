package com.hsjry.p2p.athena.dal.integration.mtbank.utils;

import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants.EnumReturnCode;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.MTBaseRes;
import com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.response.element.ReturnCode;

/**
 * Created by wangyf14377 on 2018/4/12.
 */
public class MTUtils {


    public static boolean checkIsSuccess(MTBaseRes result) {
        if(result!=null){
            ReturnCode code = result.getRst();
            return EnumReturnCode.SUCCESS.getCode().equals(code.getCode());
        }
        return false;
    }


}
