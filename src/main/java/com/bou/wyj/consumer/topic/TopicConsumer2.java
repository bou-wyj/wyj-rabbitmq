package com.bou.wyj.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者,用于消费队列信息
 */
@Component
@RabbitListener(queues = "TestTopicQueue2")
public class TopicConsumer2 {
 
    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("TopicConsumer2消费者收到消息  : " + testMessage);
    }
}