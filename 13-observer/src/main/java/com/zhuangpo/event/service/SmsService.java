package com.zhuangpo.event.service;


import com.zhuangpo.event.event.UserArrearsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 *  观察者 短信欠费通知
 * 
 * @author xub
 * @since 2023/9/8 上午8:52
 */
@Service
public class SmsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    public void smsArrears(UserArrearsEvent event) {
        logger.info("短信欠费通知，你好 {} ,请尽快缴费啊啊啊啊！", event.getUsername());
    }
}
