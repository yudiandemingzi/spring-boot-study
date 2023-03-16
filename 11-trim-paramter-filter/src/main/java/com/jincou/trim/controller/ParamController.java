package com.jincou.trim.controller;

import com.alibaba.fastjson.JSONObject;
import com.jincou.trim.model.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接口
 *
 * @author xub
 * @date 2022/10/24 下午5:06
 */
@Slf4j
@RestController
public class ParamController {

    /**
     * 1、get方法测试首尾去空格
     */
    @GetMapping(value = "/getTrim")
    public String getTrim( String username,  String phone) {
        
        return username + "&" + phone;
    }

    /**
     * 2、post方法测试首尾去空格
     */
    @PostMapping(value = "/postTrim")
    public String postTrim( String username, String phone) {
        return username + "&" + phone;
    }

    /**
     * 3、post方法 Content-Type为application/json 测试首尾去空格
     */
    @PostMapping(value = "/postJsonTrim")
    public String helloUser(@RequestBody UserDO userDO) {
        return JSONObject.toJSONString(userDO);
    }
}
