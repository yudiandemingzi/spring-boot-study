package com.jincou.third.config;

import com.jincou.third.bean.ThirdConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 *
 * @author xub
 * @date 2019/6/11 下午8:34
 */
@Configuration
@ComponentScan("com.jincou.third")
public class BeanConfig {

    @Bean
    public ThirdConfigBean thirdConfigBean() {
        return new ThirdConfigBean();
    }
}
