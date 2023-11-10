package com.bou.wyj.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者,用于消费队列信息
 */
@Component
@RabbitListener(queues = "TestTopicQueue1")
public class TopicConsumer1 {
 
    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("TopicConsumer1消费者收到消息  : " + testMessage);
    }
}