package com.jincou.exception.exception;

/**
 * 只包装了 错误信息 的 {@link RuntimeException}.
 * 用于包装自定义异常信息
 *
 * @author xub
 * @date 2022/2/25 下午1:52
 */
public class WrapMessageException extends RuntimeException {

    public WrapMessageException(String message) {
        super(message);
    }

    public WrapMessageException(String message, Throwable cause) {
        super(message, cause);
    }

}
