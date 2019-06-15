package com.jincou.conditionalon.config;

import com.jincou.conditionalon.bean.City;
import com.jincou.conditionalon.bean.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Slf4j
@Configuration
public class Config {
    @Bean
    public City city() {
        City city = new City();
        city.setCityName("千岛湖");
        return city;
    }

    /**
     * 这里加了ConditionalOnBean注解，就代表如果city存在才实例化people
     */
    @Bean
    @ConditionalOnBean(name = "city")
    public People people(City city) {
        //这里如果city实体没有成功注入 这里就会报空指针
        city.setCityCode(301701);
        return new People("小小", 3, city);
    }
}