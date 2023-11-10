package com.bou.wyj.consumer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutConsumerA {
 
    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("FanoutConsumerA消费者收到消息  : " +testMessage.toString());
    }
 
}