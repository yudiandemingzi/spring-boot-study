package com.jincou.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 1、删除 0、未删除
     */
    @TableField(value = "deleted",fill = FieldFill.INSERT)
    @TableLogic(value = "0", delval = "id")
    private Integer deleted;
}
