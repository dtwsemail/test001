/**
 * hsjry.com Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package exception;

/**
 * 借款基类异常
 * @author zhangliang08072
 * @version $Id: LoanBaseException.java, v 0.1 2015-10-26 上午10:11:17 zhangliang08072 Exp $
 */
public class BaseException extends RuntimeException {
    // 消息
    private  String msg;
    // 错误码
    private  String errorCode;
    //合作商编号
    private String partnerId;

    @Override
    public String toString() {
        StringBuffer message = new StringBuffer();
        message.append(" partnerId is :" + this.partnerId );
        message.append(" & error message is :" + this.msg);
        message.append(" & error code is " + this.errorCode);
        return message.toString();
    }

    public BaseException(String msg, String errorCode, String partnerId) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.partnerId = partnerId;
    }

    public String getMsg() {
        return msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public static void main(String[] args) {
        try {
        BaseException e1 = new BaseException("1", "2", "3");
            throw e1;
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
