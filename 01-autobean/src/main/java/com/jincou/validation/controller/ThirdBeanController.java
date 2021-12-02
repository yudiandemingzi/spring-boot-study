package com.jincou.validation.controller;

import com.alibaba.fastjson.JSON;
import com.jincou.third.bean.ThirdComponentBean;
import com.jincou.third.bean.ThirdConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 引入第三方的bean实体测试
 *
 * @author xub
 * @date 2019/6/11 下午12:36
 */
@RestController
public class ThirdBeanController {

    /**
     * 1、通过@Component方式注入bean
     */
    @Autowired
    private ThirdComponentBean thirdComponentBean;
    /**
     * 2、经典的注解引入方式 就是在@Configuration注解下生存bean
     */
    @Autowired
    private ThirdConfigBean thirdConfigBean;



    @GetMapping(path = "/third-bean")
    public String show(String name) {
        Map<String, String> map = new HashMap(16);
        map.put("ThirdComponentBean", thirdComponentBean.getName(name));
        map.put("ThirdConfigBean", thirdConfigBean.getName(name));
        return JSON.toJSONString(map);
    }
}
