package com.jincou.exception.exception;


import com.jincou.exception.constant.IResponseEnum;

/**
 *  公共(基础)异常
 *
 * @author xub
 * @date 2022/2/25 下午1:50
 */
public class CommonException extends  BaseException {

    private static final long serialVersionUID = 1L;

    public CommonException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public CommonException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
