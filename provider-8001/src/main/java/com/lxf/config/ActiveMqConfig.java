package com.lxf.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.jms.Queue;

@Configuration
public class ActiveMqConfig {
    @Value("${myqueue}")
    private String myQueue;
    @Bean
    public Queue getQueue(){

        return new ActiveMQQueue(myQueue);
    }
}
