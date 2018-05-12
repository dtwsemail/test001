package com.hsjry.p2p.athena.dal.integration.common.service.impl;

import com.hsjry.p2p.athena.common.constants.EnumBizType;
import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import com.hsjry.p2p.athena.common.constants.EnumRPCStatus;
import com.hsjry.p2p.athena.common.log.Log;
import com.hsjry.p2p.athena.common.utils.DateUtil;
import com.hsjry.p2p.athena.common.utils.JsonUtils;
import com.hsjry.p2p.athena.common.utils.PreconditionUtils;
import com.hsjry.p2p.athena.dal.dao.AthenaRpcLogDao;
import com.hsjry.p2p.athena.dal.dao.model.AthenaRpcLog;
import com.hsjry.p2p.athena.dal.integration.service.RPCService;
import com.hsjry.p2p.athena.dal.integration.service.SerialNoService;
import com.hsjry.p2p.athena.dal.integration.service.ServiceProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;

/**
 * 外部银行系统调用统一出口
 * Created by wangyf14377 on 2018/5/7.
 */
@Service
public class RPCSerivceImpl implements RPCService {

    private static final Log log = Log.get(RPCSerivceImpl.class);

    public static final int MAX_RESPONSE_SIZE = 4096;

    @Autowired
    private AthenaRpcLogDao athenaRpcLogDao;

    @Autowired
    private SerialNoService serialNoService;

    @Override
    public <REQUEST,RESPONSE> RESPONSE doService(String partnerId, String bizSerialNo, EnumBizType bizType, REQUEST request, ServiceProtocol<REQUEST, RESPONSE> protocol, Class returnClazz) {
        return this.doService(partnerId, bizSerialNo, bizType,request, protocol, returnClazz,true);
    }

    @Override
    public  <REQUEST,RESPONSE> RESPONSE doService(String partnerId, String bizSerialNo, EnumBizType bizType,REQUEST request, ServiceProtocol<REQUEST,RESPONSE> protocol, Class returnClazz,boolean isRecord) {
        long startTime = System.nanoTime();
        try {
            //远程调用
            String result = protocol.doService(request);
            long endTime = System.nanoTime();
            RESPONSE response =  protocol.getResult(result,returnClazz);
            boolean isSuccess = protocol.checkIsSuccess(response);
            recordRpcLog(partnerId,bizSerialNo,bizType,request,result, isSuccess? EnumRPCStatus.SUCCESS:EnumRPCStatus.FAIL,endTime-startTime);
        } catch (SocketTimeoutException oe){
            log.error(oe,"处理超时");
            long exceptionTime = System.nanoTime();
            recordRpcLog(partnerId,bizSerialNo,bizType,request,null ,EnumRPCStatus.TIMEOUT,exceptionTime-startTime);
            PreconditionUtils.throwTimeoutException(partnerId, "调用外部系统接口超时");
        } catch(Exception e) {
            log.error(e,"处理失败");
            long exceptionTime = System.nanoTime();
            recordRpcLog(partnerId,bizSerialNo,bizType,request,e.getMessage(),EnumRPCStatus.FAIL,exceptionTime-startTime);
            PreconditionUtils.throwException(partnerId,"调用外部系统报错",EnumErrorCode.SERVER_ERROR);
        }
        return null;
    }

    private <REQUEST,RESPONSE> void recordRpcLog(String partnerId, String bizSerialNo, EnumBizType bizType, REQUEST request, String response, EnumRPCStatus status, long dealTime) {
        try {
            AthenaRpcLog log = new AthenaRpcLog();
            log.setId(serialNoService.generateCommonSerivce());
            log.setPartnerId(partnerId);
            log.setPartnerSerialNo(bizSerialNo);
            log.setRequest(JsonUtils.toJSONString(request));
            log.setResponse(response.length()> MAX_RESPONSE_SIZE ?  response.substring(0,MAX_RESPONSE_SIZE): response);
            log.setDealTime(dealTime);
            if (bizType == null) {
                log.setBizType(bizType.getCode());
            }
            if (status == null) {
                log.setStatus(status.getCode());
            }
            log.setCreateTime(DateUtil.getNow());
            athenaRpcLogDao.insert(log);
        } catch (Exception e) {
            log.error(e, "登记日志出错");
        }

    }
}
