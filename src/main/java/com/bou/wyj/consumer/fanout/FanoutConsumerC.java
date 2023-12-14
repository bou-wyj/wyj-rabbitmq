// package com.bou.wyj.consumer.fanout;
//
// import org.springframework.amqp.rabbit.annotation.RabbitHandler;
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.stereotype.Component;
//
// @Component
// @RabbitListener(queues = "fanout.C")
// public class FanoutConsumerC {
//
//     @RabbitHandler
//     public void process(String testMessage) {
//         System.out.println("FanoutConsumerC消费者收到消息  : " +testMessage.toString());
//     }
//
// }