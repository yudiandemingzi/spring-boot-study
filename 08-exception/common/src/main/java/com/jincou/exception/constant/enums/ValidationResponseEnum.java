package com.jincou.exception.constant.enums;


import com.jincou.exception.exception.assertion.ValidationExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  参数校验异常返回结果
 *
 * @author xub
 * @date 2022/2/28 上午11:23
 */
@Getter
@AllArgsConstructor
public enum ValidationResponseEnum implements ValidationExceptionAssert {
    /**
     * 绑定参数校验异常
     */
    VALID_ERROR(6000, "参数校验异常"),

    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

}
