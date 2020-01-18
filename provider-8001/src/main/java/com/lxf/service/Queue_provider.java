package com.lxf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.UUID;

@Service
public class Queue_provider {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue  queue;

    public void produceMsg(){

        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0,9));
    }
}
