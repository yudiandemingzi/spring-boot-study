package com.jincou.exception.constant;


/**
 *  异常返回码枚举接口
 *
 * @author xub
 * @date 2022/2/25 上午11:17
 */
public interface IResponseEnum {
    /**
     * 获取返回码
     * @return 返回码
     */
    int getCode();

    /**
     * 获取返回信息
     * @return 返回信息
     */
    String getMessage();
}
