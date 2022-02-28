package com.jincou.exception.exception.assertion;

import cn.hutool.core.util.ArrayUtil;
import com.jincou.exception.constant.IResponseEnum;
import com.jincou.exception.exception.CommonException;
import com.jincou.exception.exception.BaseException;


import java.text.MessageFormat;

/**
 *  公共异常断言
 *
 * @author xub
 * @date 2022/2/25 下午1:46
 */
public interface CommonExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = this.getMessage();
        if (ArrayUtil.isNotEmpty(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new CommonException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = this.getMessage();
        if (ArrayUtil.isNotEmpty(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }

        return new CommonException(this, args, msg, t);
    }

}
