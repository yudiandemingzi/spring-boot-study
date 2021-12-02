package com.jincou.validation.model;

import lombok.Data;
import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationList<E> implements List<E> {

    @Delegate // @Delegate是lombok注解
    @Valid // 一定要加@Valid注解
    public List<E> list = new ArrayList<>();

    /**
     * 一定要记得重写toString方法
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
