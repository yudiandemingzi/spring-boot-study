package com.jincou.apollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private static Logger log = LoggerFactory.getLogger( TestController.class );
    private static Logger logger = LoggerFactory.getLogger( TestController.class );



    @Value( "${date.value}" )
    String dateValue;

    @GetMapping("test")
    public String test() {
        return "打印配置中心的 dateValue 值: "+ dateValue;
    }


    @GetMapping("test1")
    public void test1() {
        log.info("当前配置中心的 dateValue 值 = {}",dateValue);
    }

    @GetMapping("test2")
    public void test2() {
        logger.debug("我是 debug 打印出的日志");
        logger.info("我是 info 打印出的日志");
        logger.error("我是 error 打印出的日志");
    }

}
