package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants;

/**
 * Created by wangyf14377 on 2018/5/9.
 */
public enum  EnumReturnCode {

    SUCCESS("00000","交易成功");

    private String code;
    private String description;

    EnumReturnCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnumReturnCode find(String code) {
        for (EnumReturnCode frs : EnumReturnCode.values()) {
            if (frs.getCode().equals(code)) {
                return frs;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
