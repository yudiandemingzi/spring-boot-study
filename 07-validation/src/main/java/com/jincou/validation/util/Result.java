package com.jincou.validation.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  xub
 *
 * @author xub
 * @date 2021/11/29 下午9:16
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -504027247149928390L;

    private int code;
    private String msg;
    private String exceptionMsg;
    private T body;

    public static <T> Result success(T body) {
        return new Result<>()
                .setBody(body)
                .setCode(0)
                .setMsg("成功");
    }

    public static Result success() {
        return new Result<>()
                .setCode(0)
                .setMsg("成功");
    }

    public static Result fail(BusinessCode businessCode) {
        return new Result<>()
                .setCode(businessCode.getCode())
                .setMsg(businessCode.getMessage());
    }


    public static Result fail(BusinessCode returnCode, String exceptionMsg) {
        return new Result<>()
                .setCode(returnCode.getCode())
                .setMsg(returnCode.getMessage())
                .setExceptionMsg(exceptionMsg);
    }

}
