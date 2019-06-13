package com.jincou.conditional.config;


import com.jincou.conditional.bean.SystemBean;
import com.jincou.conditional.systemcondtion.MacCondition;
import com.jincou.conditional.systemcondtion.WindowsCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ConditionalConfig {
    /**
     * 如果WindowsCondition的实现方法返回true，则注入这个bean
     */
    @Bean("windows")
   // @Conditional({WindowsCondition.class})
    public SystemBean systemWi() {
        log.info("ConditionalConfig方法注入 windows实体");
        return new SystemBean("windows系统","002");
    }

    /**
     * 如果LinuxCondition的实现方法返回true，则注入这个bean
     */
    @Bean("mac")
    @Conditional({MacCondition.class})
    public SystemBean systemMac() {
        log.info("ConditionalConfig方法注入 mac实体");
        return new SystemBean("Mac ios系统","001");
    }
}