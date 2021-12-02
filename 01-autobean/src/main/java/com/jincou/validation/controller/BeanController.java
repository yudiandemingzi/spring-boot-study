package com.jincou.validation.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jincou.validation.simple.ComponentBean;
import com.jincou.validation.simple.ConfigBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 当前工程下的bean实体测试
 *
 * @author xub
 * @date 2019/6/11 下午12:36
 */
@RestController
public class BeanController {

    /**
     * 1、经典的注解引入方式 就是在@Configuration注解下生存bean
     */
    @Autowired
    private ConfigBean configBean;
    /**
     * 2、通过@Component方式注入bean 这里通过构造方法引入方式（也可和上面一样通过@Autowired注入 只是方式不同）
     */
    private ComponentBean componentBean;
    public BeanController(ComponentBean componentBean) {
        this.componentBean = componentBean;
    }


    @GetMapping(path = "/bean")
    public String show(String name) {
        Map<String, String> map = new HashMap(16);
        map.put("ComponentBean", componentBean.getName(name));
        map.put("ConfigBean", configBean.getName(name));
        return JSON.toJSONString(map);
    }
}
