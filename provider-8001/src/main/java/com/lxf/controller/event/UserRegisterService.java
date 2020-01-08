package com.lxf.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author lxf
 * @date 2020/1/7 16:32
 * @modified
 * @description
 */
@Service
public class UserRegisterService implements ApplicationEventPublisherAware {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public String success(User user) {
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, user));
        System.out.println("注册成功");
        return "用户注册成功" + user;
    }

    ;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
