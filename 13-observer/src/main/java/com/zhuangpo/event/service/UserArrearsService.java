package com.zhuangpo.event.service;

import com.zhuangpo.event.event.UserArrearsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 *  被观察者
 * 
 * @author xub
 * @since 2023/9/8 上午9:30
 */
@Service
public class UserArrearsService implements ApplicationEventPublisherAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void arrears(String username) {
        // 执行欠费逻辑
        logger.info("被观察者 用户欠费,用户名称 = {}", username);
        // 发布
        applicationEventPublisher.publishEvent(new UserArrearsEvent(this, username));
    }

}