package com.hsjry.p2p.athena.dal.integration.mtbank.protocol.socket.request.constants;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public enum EnumInstitutionType {
    SERVANT("0", "服务商"),
    BANK("1", "银行");

    private String code;
    private String description;

    EnumInstitutionType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnumInstitutionType find(String code) {
        for (EnumInstitutionType frs : EnumInstitutionType.values()) {
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
