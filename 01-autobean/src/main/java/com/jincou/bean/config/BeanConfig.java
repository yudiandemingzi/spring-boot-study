package com.jincou.bean.config;


import com.jincou.bean.factory.FacBean;
import com.jincou.bean.factory.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jincou.bean.simple.ConfigBean;

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
