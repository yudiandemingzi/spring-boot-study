package com.jincou.exception.controller;


import com.jincou.exception.dto.UserDTO;
import com.jincou.exception.pojo.CommandResult;
import com.jincou.exception.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;


/**
 *  模拟查询用户信息
 *
 * @author xub
 * @date 2022/2/28 上午10:06
 */
@RestController
@Validated
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUserInfo")
    public CommandResult<UserDTO> getUser(@NotNull(message="userId不能为空")  Integer userId) {
        return userService.queryDetail(userId);

    }
}
