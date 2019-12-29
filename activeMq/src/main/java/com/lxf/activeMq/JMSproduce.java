package com.lxf.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSproduce {
    public static final String DEFAULT_BROKER_BIND_URL="tcp://192.168.0.105:61616";
    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        //创建连接
        Connection connection= activeMQConnectionFactory.createConnection();
        connection.start();
       Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        String queueName="lxf";
        Queue  queue= session.createQueue(queueName);
        MessageProducer  messageProducer =session.createProducer(queue);
       for(int i=0;i<3;i++){
           TextMessage  textMessage=session.createTextMessage("消息来源与lxf的------"+i);
           messageProducer.send(textMessage);
       }
        messageProducer.close();
       session.close();
       connection.close();
        System.out.println("消息船舰完毕");
    }
}
