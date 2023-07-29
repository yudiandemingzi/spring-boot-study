package com.jincou.validation.controller;

import com.jincou.validation.model.UserDTO;
import com.jincou.validation.model.ValidationList;
import com.jincou.validation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.Set;


/**
 *  用户
 *
 * @author xub
 * @date 2021/11/29 下午9:22
 */
@RequestMapping("/api/user")
@RestController
@Validated
@Api("用户管理")
public class UserController {


    @PostMapping("/save")
    @ApiOperation("保存用户")
    public Result saveUser(@RequestBody @Validated UserDTO userDTO) {
        // 校验通过，才会执行业务逻辑处理
        return Result.success();
    }


    @PostMapping("/update")
    @ApiOperation("更新用户信息")
    public Result updateUser(@RequestBody @Validated({UserDTO.Update.class, Default.class}) UserDTO userDTO) {
        // 校验通过，才会执行业务逻辑处理
        return Result.success();
    }


    @GetMapping("{userId}")
    @ApiOperation("根据userId查询用户信息")
    public Result detail(@PathVariable("userId") @Min(10000000000000000L) @ApiParam("用户id")  Long userId) {
        // 校验通过，才会执行业务逻辑处理

        return Result.success();
    }

    @GetMapping("getByUserName")
    @ApiOperation("根据userName查询用户信息")
    public Result getByUserName(@Length(min = 6, max = 20) @NotNull @ApiParam("用户名称")   String userName) {
        // 校验通过，才会执行业务逻辑处理
        return Result.success();
    }

    //============验证集合====================

    @PostMapping("/saveList")
    @ApiOperation("批量保存用户信息")
    public Result saveList(@RequestBody @Validated(UserDTO.Save.class) ValidationList<UserDTO> userList) {
        // 校验通过，才会执行业务逻辑处理
        return Result.success();
    }


    //=========编程式校验======================

    @Autowired
    private javax.validation.Validator globalValidator;

    // 编程式校验
    @PostMapping("/saveWithCodingValidate")
    @ApiOperation("编程式校验")
    public Result saveWithCodingValidate(@RequestBody UserDTO userDTO) {
        Set<ConstraintViolation<UserDTO>> validate = globalValidator.validate(userDTO, UserDTO.Save.class);
        // 如果校验通过，validate为空；否则，validate包含未校验通过项
        if (validate.isEmpty()) {
            // 校验通过，才会执行业务逻辑处理

        } else {
            for (ConstraintViolation<UserDTO> userDTOConstraintViolation : validate) {
                // 校验失败，做其它逻辑
                System.out.println(userDTOConstraintViolation);
            }
        }
        return Result.success();
    }

}
