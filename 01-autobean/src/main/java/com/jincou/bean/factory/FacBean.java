package com.jincou.bean.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 通过工厂模式生产bean
 *
 * @author xub
 * @date 2019/6/11 下午10:00
 */
@Slf4j
public class FacBean {
    private String type = "FacBean通过工厂模式生产bean";

    public FacBean() {
        log.info("工厂模式生产bean 加载时间: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
