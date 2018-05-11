package com.hsjry.p2p.athena.common.constants;

/**
 * Created by wangyf14377 on 2018/4/9.
 */
public enum  EnumCustodianType {

    MTBank("MTBank","民泰银行");

    private String code;
    /**
     * 状态描述
     **/
    private String description;

    /**
     * 私有构造方法
     *
     * @param code        编码
     * @param description 描述
     **/
    private EnumCustodianType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnumCustodianType find(String code) {
        for (EnumCustodianType frs : EnumCustodianType.values()) {
            if (frs.getCode().equals(code)) {
                return frs;
            }
        }
        return null;
        //throw new Exception("错误码", "根据code=" + code+ "获取渠道标示失败");
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     **/
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     **/
    public String getDescription() {
        return description;
    }
}
