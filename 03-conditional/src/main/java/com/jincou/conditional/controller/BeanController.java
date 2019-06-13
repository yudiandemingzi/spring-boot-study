package com.jincou.conditional.controller;


import com.jincou.conditional.bean.SystemBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 当前工程下的bean实体测试
 *
 * @author xub
 * @date 2019/6/11 下午12:36
 */
@RestController
public class BeanController {

    @Autowired
    private SystemBean windows;


    @Autowired
    private SystemBean mac;


    @GetMapping("system")
    public void test() {
        if (windows != null) {
            System.out.println("windows = " + windows);
        }

        if (mac != null) {
            System.out.println("linux = " + mac);

        }
    }
}
