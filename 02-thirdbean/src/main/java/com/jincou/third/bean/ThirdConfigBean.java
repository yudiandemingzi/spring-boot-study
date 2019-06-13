package com.jincou.third.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 通过Configuration注解生成bean实体
 *
 * @author xub
 * @date 2019/6/11 下午4:52
 */
@Slf4j
public class ThirdConfigBean {

    private String type = "第三方 ThirdConfigBean注解生成bean实体";

    public ThirdConfigBean() {
        log.info("第三方 ThirdConfigBean注解生成bean实体 time:{}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
