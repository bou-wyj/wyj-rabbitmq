// package com.bou.wyj.consumer.fanout;
//
// import org.springframework.amqp.rabbit.annotation.RabbitHandler;
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.stereotype.Component;
//
// @Component
// @RabbitListener(queues = "fanout.B")
// public class FanoutConsumerB {
//
//     @RabbitHandler
//     public void process(String testMessage) {
//         System.out.println("FanoutConsumerB消费者收到消息  : " +testMessage.toString());
//     }
//
// }