/**
 * Copyright (c) 2014-2015 All Rights Reserved.
 * hsjry.com Inc.
 */
package com.hsjry.p2p.athena.common.constants;

/**
 * 借款平台错误码
 *
 * @author zhangliang08072
 * @version $Id: EnumLoanErrorCode.java, v 0.1 2015-10-20 上午11:31:46 zhangliang08072 Exp $
 */
public enum EnumErrorCode {
	
    SUCCESS("000000","处理成功"),
    PARAMETER_ERROR("000001","参数校验不正确"),
    CONFIG_ERROR("000002","系统配置不正确"),
    /** 通用错误 */
    SYSTEM_ERROR("999999","系统异常"),
    /** 调用外部服务异常 */
    SERVER_ERROR("999998","服务调用异常"),
    /** 调用服务处理超时 */
    TIMEOUT_ERROR("999997" , "服务超时"),
    /** 幂等校验 */
    UNEXPECTED_EXCEPTION("900007", "系统预期外异常"), 
	PARAM_EXCEPTION("900008", "入参校验失败"), 
	DB_EXCEPTION("900009", "数据库操作异常"),
	/** ------------------------数据DB类异常----------------------- */
    DB_ADD_ERR("900010","数据库新增错误"),
    DB_UPDATE_ERR("900011","数据库修改错误"),
    DB_QUERY_ERR("900012","数据库查询错误"),
    DB_DEL_ERR("900013","数据库删除错误"),
    OPTIMISTIC_LOCK_ERR("900014","乐观锁加锁失败"),
	

    
	;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误描述
     */
    private String errorDesc;

    /**
     * @param errorCode
     * @param errorCode
     * @param errorDesc
     */
    private EnumErrorCode(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     *
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorDesc</tt>.
     *
     * @return property value of errorDesc
     */
    public String getErrorDesc() {
        return errorDesc;
    }

    /**
     * Setter method for property <tt>errorDesc</tt>.
     *
     * @param errorDesc value to be assigned to property errorDesc
     */
    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
    

    public static EnumErrorCode find(String code) {
        for (EnumErrorCode frs : EnumErrorCode.values()) {
            if (frs.getErrorCode().equals(code)) {
                return frs;
            }
        }
        return null;
    }

}
