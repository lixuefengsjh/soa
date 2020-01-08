package com.lxf.controller.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author lxf
 * @date 2020/1/7 16:23
 * @modified
 * @description 测试事件功能
 */
public class UserRegisterEvent extends ApplicationEvent {
    private  User user;
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user=user;
    }
    public User getUser(){
        return user;
    }
}
