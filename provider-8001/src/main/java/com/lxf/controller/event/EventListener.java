package com.lxf.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lxf
 * @date 2020/1/7 16:48
 * @modified
 * @description
 */
@Component
public class EventListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {

        //发邮件
        System.out.println("正在发送邮件至： " + event.getUser().getEmail());

        //发短信
        System.out.println("正在发短信到： " + event.getUser().getPhoneNum());

    }

}
