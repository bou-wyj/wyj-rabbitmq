package com.bou.wyj.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者,用于消费队列信息
 */
@Component
@RabbitListener(queues = "TestDirectQueue")// 监听的队列名称 TestDirectQueue
public class DirectConsumerA {
 
    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("DirectReceiver消费者A收到消息  : " + testMessage);
    }
 
}