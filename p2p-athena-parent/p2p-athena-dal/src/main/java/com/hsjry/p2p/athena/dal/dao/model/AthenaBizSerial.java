package com.hsjry.p2p.athena.dal.dao.model;

import java.util.Date;

public class AthenaBizSerial extends AthenaBizSerialKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column athena_biz_serial.biz_type
     *
     * @mbg.generated
     */
    private String bizType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column athena_biz_serial.parameter
     *
     * @mbg.generated
     */
    private String parameter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column athena_biz_serial.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column athena_biz_serial.callback_time
     *
     * @mbg.generated
     */
    private Date callbackTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column athena_biz_serial.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column athena_biz_serial.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column athena_biz_serial.biz_type
     *
     * @return the value of athena_biz_serial.biz_type
     *
     * @mbg.generated
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column athena_biz_serial.biz_type
     *
     * @param bizType the value for athena_biz_serial.biz_type
     *
     * @mbg.generated
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column athena_biz_serial.parameter
     *
     * @return the value of athena_biz_serial.parameter
     *
     * @mbg.generated
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column athena_biz_serial.parameter
     *
     * @param parameter the value for athena_biz_serial.parameter
     *
     * @mbg.generated
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column athena_biz_serial.status
     *
     * @return the value of athena_biz_serial.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column athena_biz_serial.status
     *
     * @param status the value for athena_biz_serial.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column athena_biz_serial.callback_time
     *
     * @return the value of athena_biz_serial.callback_time
     *
     * @mbg.generated
     */
    public Date getCallbackTime() {
        return callbackTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column athena_biz_serial.callback_time
     *
     * @param callbackTime the value for athena_biz_serial.callback_time
     *
     * @mbg.generated
     */
    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column athena_biz_serial.create_time
     *
     * @return the value of athena_biz_serial.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column athena_biz_serial.create_time
     *
     * @param createTime the value for athena_biz_serial.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column athena_biz_serial.update_time
     *
     * @return the value of athena_biz_serial.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column athena_biz_serial.update_time
     *
     * @param updateTime the value for athena_biz_serial.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}