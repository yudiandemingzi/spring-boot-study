package com.jincou.conditionalon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: TODO
 *
 * @author xub
 * @date 2019/6/13 下午12:49
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class People {
  /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     *  城市信息
     */
    private City city;
}
