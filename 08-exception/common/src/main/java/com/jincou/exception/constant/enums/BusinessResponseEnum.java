package com.jincou.exception.constant.enums;

import com.jincou.exception.exception.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  业务异常枚举
 *
 * @author xub
 * @date 2022/2/25 下午5:18
 */
@Getter
@AllArgsConstructor
public enum BusinessResponseEnum implements BusinessExceptionAssert {


    USER_NOT_FOUND(6001, "未查询到用户信息"),

    ORDER_NOT_FOUND(7001, "未查询到订单信息"),

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