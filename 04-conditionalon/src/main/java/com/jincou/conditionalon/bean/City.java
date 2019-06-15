package com.jincou.conditionalon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 城市信息
 *
 * @author xub
 * @date 2019/6/13 下午12:49
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市code
     */
    private Integer cityCode;
}
