package com.jincou.trim.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

   
}
