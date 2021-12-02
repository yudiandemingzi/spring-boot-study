package com.jincou.validation.config;


import com.jincou.validation.factory.FacBean;
import com.jincou.validation.factory.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jincou.validation.simple.ConfigBean;

/**
 * @Description: 生成Bean
 *
 * @author xub
 * @date 2019/6/11 下午12:34
 */
@Configuration
public class BeanConfig {

    @Bean
    public ConfigBean configBean() {
        return new ConfigBean();
    }

    @Bean
    public Factory factory() {
        return new Factory();
    }

    @Bean
    public FacBean facBean(Factory factory) throws Exception {
        return factory.getObject();
    }
}
