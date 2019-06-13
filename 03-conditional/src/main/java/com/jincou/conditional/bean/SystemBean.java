package com.jincou.conditional.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SystemBean {
    /**
     * 系统名称
     */
    private String  systemName;

    /**
     * 系统code
     */
    private String systemCode;
}
