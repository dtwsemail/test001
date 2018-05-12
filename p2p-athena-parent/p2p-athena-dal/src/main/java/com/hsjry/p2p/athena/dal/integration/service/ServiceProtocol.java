package com.hsjry.p2p.athena.dal.integration.service;

/**
 * Created by wangyf14377 on 2018/5/7.
 */
public interface ServiceProtocol<REQUEST, RESPONSE> {

    /**
     * 调用托管接口服务
     * @param bean
     * @return
     * @throws Exception
     */
    String doService(REQUEST bean) throws Exception;


    /**
     * 注意catch异常，如果报文解析失败请返回null。
     *
     * 将托管接口解析成对象
     * @param result 托管返回报文
     * @param retunClazz 返回类型
     * @return 解析失败： null
     */
    RESPONSE getResult(String result,Class<RESPONSE> retunClazz);

    /**
     * 注意catch异常，如果直接抛出异常，会导致rpc不会记录流水信息
     *
     * 判断请求是否成功，主要用于记录流水表状态字段
     * @param result
     * @return
     */
    boolean checkIsSuccess(RESPONSE result);
}
