package com.hsjry.p2p.athena.common.constants;

/**
 * Created by wangyf14377 on 2018/5/10.
 */
public enum EnumBizStatus {

    REQUEST_INIT("0", "请求受理"),
    REQUEST_SUCCESS("1", "请求成功"),
    REQUEST_FAIL("2", "请求失败"),
    CALLBACK_SUCCESS("3", "银行返回成功"),
    CALLBACK_FAIL("4", "银行返回失败"),
    REQUEST_TIMEOUT("5", "请求发送超时"),
    REQUEST_EXCEPTION("6", "请求内部异常");

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
    private EnumBizStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnumBizStatus find(String code) {
        for (EnumBizStatus frs : EnumBizStatus.values()) {
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
