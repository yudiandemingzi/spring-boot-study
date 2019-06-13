package com.jincou.bean.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 通过Configuration注解生成bean实体
 *
 * @author xub
 * @date 2019/6/11 下午12:28
 */
@Slf4j
public class ConfigBean {
    private String type = "Configuration注解生成bean实体";

    public ConfigBean() {
        log.info("Configuration注解生成bean实体 加载时间: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
