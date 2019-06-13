package com.jincou.third.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: 这个bean作为第三方bean 给依赖该jar包的项目使用
 *
 * @author xub
 * @date 2019/6/11 下午4:32
 */
@Slf4j
@Component
public class ThirdComponentBean {
    private String type = "第三方ThirdComponent注解生成bean实体";
    public ThirdComponentBean() {
        log.info("第三方ThirdComponentBean time:{}", System.currentTimeMillis());
    }
    public String getName(String name) {
        return name + " ___ " + type;
    }
}
