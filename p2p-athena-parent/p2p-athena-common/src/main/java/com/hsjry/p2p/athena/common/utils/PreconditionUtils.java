package com.hsjry.p2p.athena.common.utils;


import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import exception.BaseException;
import exception.TimeoutException;

public class PreconditionUtils {


    public static void checkNotNull(String tenantId, Object obj,
                                    String errorMsg, EnumErrorCode errorCode) {
        doCheck(tenantId, obj != null, errorMsg, errorCode);
    }

    public static void checkArgument(String tenantId, boolean expression,
                                     String errorMsg, EnumErrorCode errorCode) {
        doCheck(tenantId, expression, errorMsg, errorCode);
    }

    public static void checkState(String tenantId, boolean expression,
                                  String errorMsg, EnumErrorCode errorCode) {
        doCheck(tenantId, expression, errorMsg, errorCode);
    }

    public static void throwException(String tenantId, String errorMsg, EnumErrorCode errorCode) {
        doCheck(tenantId, false, errorMsg, errorCode);
    }

    public static void throwTimeoutException(String tenantId, String errorMsg) {
        throw new TimeoutException(errorMsg, EnumErrorCode.TIMEOUT_ERROR.getErrorCode(), tenantId);
    }

    private static void doCheck(String tenantId, boolean expression,
                                String errorMsg, EnumErrorCode errorCode) {
        if (!expression) {
            throw new BaseException(errorMsg, errorCode.getErrorCode(), tenantId);
        }
    }
}
