package com.lxf.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSconsumer {
    public static final String DEFAULT_BROKER_BIND_URL="tcp://192.168.0.105:61616";
    public static void main(String[] args) throws JMSException,Exception {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        //创建连接
        Connection connection= activeMQConnectionFactory.createConnection();
        connection.start();
        Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        String queueName="lxf";
        Queue queue= session.createQueue(queueName);
        MessageConsumer messageConsumer=session.createConsumer(queue);
        //1.第一种形式
//        while (true){
//            TextMessage textMessage= (TextMessage) messageConsumer.receive();
//            System.out.println("消费者开始消费，接收到的信息为$$"+textMessage.getText());
//        }
        messageConsumer.setMessageListener(var1->{
            //这里使用的监听器的心事获取消息，这样的编写方式是错误的
//            TextMessage textMessage= null;
//            try {
//                textMessage = (TextMessage) messageConsumer.receive();
//                System.out.println("消费者开始消费，接收到的信息为$$"+textMessage.getText());
//            } catch (JMSException e) {
//                e.printStackTrace();
//            }
            TextMessage textMessage=(TextMessage)var1;
            try {
                System.out.println("消费者开始消费，接收到的信息为$$"+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        });
        System.in.read();
    }
}
