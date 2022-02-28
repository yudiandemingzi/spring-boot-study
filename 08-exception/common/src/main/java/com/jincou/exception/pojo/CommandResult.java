package com.jincou.exception.pojo;

import com.jincou.exception.constant.enums.CommonResponseEnum;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *  返回业务类
 *
 * @author xub
 * @date 2022/2/25 下午2:30
 */
@Getter
public final class CommandResult<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandResult.class);
    private final int code;
    private final String message;
    private final T result;

    public CommandResult(int code, String msg, T result) {
        this.code = code;
        this.message = msg;
        this.result = result;
    }

    public CommandResult(int code, String msg) {
        this.code = code;
        this.message = msg;
        this.result = null;
    }

    public static <T> CommandResult<T> ofFail(String msg) {
        return new CommandResult(CommonResponseEnum.SERVER_BUSY.getCode(), msg);
    }

    public static <T> CommandResult<T> ofFail(int code, String msg) {
        return new CommandResult(code, msg);
    }

    public static <T> CommandResult<T> ofFail(String msg, T t) {
        return new CommandResult(CommonResponseEnum.SERVER_BUSY.getCode(), msg);
    }

    public static <T> CommandResult<T> ofSucceed(T value) {

        return new CommandResult(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getMessage(), value);
    }

    public static CommandResult<Void> ofSucceed() {
        return new CommandResult(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getMessage());
    }

    public static <T> CommandResult<T> ofSucceed(String msg, T value) {
        return new CommandResult(CommonResponseEnum.SUCCESS.getCode(), msg, value);
    }


    public boolean isSuccess() {
        return this.code == CommonResponseEnum.SUCCESS.getCode();
    }


}

