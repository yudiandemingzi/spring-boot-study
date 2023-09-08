package com.zhuangpo.event.service;

import com.zhuangpo.event.event.UserArrearsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *  观察者 邮箱欠费通知
 * 
 * @author xub
 * @since 2023/9/8 上午10:11
 */
@Service
public class EmailService implements ApplicationListener<UserArrearsEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Async
    public void onApplicationEvent(UserArrearsEvent event) {
        logger.info("邮箱欠费通知，你好 {} ,请尽快缴费啊啊啊啊！", event.getUsername());
    }
}