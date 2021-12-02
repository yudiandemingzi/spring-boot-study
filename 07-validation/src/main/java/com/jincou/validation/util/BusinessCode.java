package com.jincou.validation.util;

/**
 * @author 陈添明
 * @date 2019/3/5
 */
public enum BusinessCode{


    SUCCESS(0, "成功"),
    SYSTEM_ERROR(-1, "系统错误"),
    MISSING_PARAMETERS(-4, "参数校验失败");

    /**
     * 业务编号
     */
    private int code;

    /**
     * 业务值
     */
    private String message;

    BusinessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
