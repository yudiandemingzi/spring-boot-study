package com.jincou.bean.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: 通过@Component注解实例化bean
 * @author xub
 * @date 2019/6/11 下午12:26
 */
@Slf4j
@Component
public class ComponentBean {
    private String type = "@Component实例化bean";

    public ComponentBean() {
        log.info("@Component生成bean实体 加载时间: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
