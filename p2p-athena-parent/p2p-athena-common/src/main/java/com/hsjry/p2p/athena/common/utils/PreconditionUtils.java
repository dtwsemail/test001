package com.hsjry.p2p.athena.common.utils;


import com.hsjry.p2p.athena.common.constants.EnumErrorCode;
import exception.BaseException;

public class PreconditionUtils {

    public static void checkNotNull(Object obj, String errorMsg, EnumErrorCode errorCode) {
        checkNotNull(null, errorMsg, errorCode);
    }

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

    private static void doCheck(String tenantId, boolean expression,
                                String errorMsg, EnumErrorCode errorCode) {
        if (!expression) {
            throw new BaseException(errorMsg, errorCode.getErrorCode(), tenantId);
        }
    }
}
