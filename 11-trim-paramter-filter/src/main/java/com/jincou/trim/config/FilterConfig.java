package com.jincou.trim.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;



/**
 *  通过FilterRegistrationBean注册自定义过滤器TrimFilter
 */
@Configuration
public class FilterConfig {

    /**
     * 注册去除参数头尾空格过滤器
     */
    @Bean
    public FilterRegistrationBean trimFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        //注册自定义过滤器
        registration.setFilter(new TrimFilter());
        //过滤所有路径
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("trimFilter");
        //优先级越低越优先，这里说明最低优先级
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }
}
