package com.zhuangpo.event.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户欠费事件 继承ApplicationEvent
 *
 * @author xub
 * @since 2023/9/8 上午8:46
 */
public class UserArrearsEvent extends ApplicationEvent {

    /**
     * 用户名
     */
    private String username;
    
    public UserArrearsEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}