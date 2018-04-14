package com.hsjry.p2p.athena.dal.integration.mtbank.request.xml.constants;

import com.hsjry.p2p.athena.common.constants.EnumBizType;

/**
 * Created by wangyf14377 on 2018/4/11.
 */
public enum EnumSystemType {
    
    REGULATORY_SYSTEM("5", "监管系统");


    private String code;
    private String description;

    EnumSystemType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnumBizType find(String code) {
        for (EnumBizType frs : EnumBizType.values()) {
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
