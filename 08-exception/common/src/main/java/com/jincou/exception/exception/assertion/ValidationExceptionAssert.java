package com.jincou.exception.exception.assertion;

import cn.hutool.core.util.ArrayUtil;
import com.jincou.exception.constant.IResponseEnum;
import com.jincou.exception.exception.BaseException;
import com.jincou.exception.exception.ValidationException;


import java.text.MessageFormat;

/**
 *  参数异常断言
 *
 * @author xub
 * @date 2022/2/25 下午1:46
 */
public interface ValidationExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = this.getMessage();
        if (ArrayUtil.isNotEmpty(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new ValidationException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = this.getMessage();
        if (ArrayUtil.isNotEmpty(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new ValidationException(this, args, msg, t);
    }

}
