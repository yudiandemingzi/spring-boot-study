package com.jincou.exception.util;


import com.jincou.exception.constant.enums.CommonResponseEnum;
import com.jincou.exception.pojo.CommandResult;

import java.util.function.Supplier;

/**
 *  远程调用工具类
 * 
 * @author xub
 * @date 2022/9/26 上午10:09
 */
public class ClientUtil {

    /**
     * 封装远程调用, 只返回关心的内容
     * @param supplier 远程调用真正逻辑, 返回内容为: {@link CommandResult<T>}
     * @param <T> 关心的内容类型
     * @return 关心的内容
     */
    public static <T> T execute(Supplier<CommandResult<T>> supplier) {
        CommandResult<T> r = supplier.get();
        CommonResponseEnum.assertSuccess(r);
        return r.getResult();
    }



}
