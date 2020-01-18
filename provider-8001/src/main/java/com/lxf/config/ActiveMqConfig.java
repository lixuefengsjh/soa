package com.lxf.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

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
