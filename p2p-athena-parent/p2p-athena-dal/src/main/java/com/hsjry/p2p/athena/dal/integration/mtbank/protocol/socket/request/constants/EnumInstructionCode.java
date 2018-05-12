package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public enum EnumInstructionCode {
    SERVANT_SIGN("54901","服务商签到"),
    CLIENT_SIGN("55701", "客户签约"),
    SOFT_ENCTY_KEY_CHANGE("56700", "软加密密钥交换"),
    SERVANT_PROFIT_TRANS("54705", "服务商收益划出");


    private String code;
    private String description;

    EnumInstructionCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnumInstructionCode find(String code) {
        for (EnumInstructionCode frs : EnumInstructionCode.values()) {
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
