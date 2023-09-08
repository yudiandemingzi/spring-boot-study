package com.zhuangpo.event.controller;

import com.zhuangpo.event.service.UserArrearsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  测试 Sping Event观察者模式
 * 
 * @author xub
 * @since 2023/9/8 上午9:33
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private UserArrearsService userArrearsService;

    @GetMapping("/arrears")
    public String arrears(String username) {
        userArrearsService.arrears(username);
        return "成功";
    }

}
