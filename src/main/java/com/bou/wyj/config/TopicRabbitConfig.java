// package com.bou.wyj.config;
//
// import org.springframework.amqp.core.*;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// public class TopicRabbitConfig {
//
//     @Bean
//     TopicExchange exchange() {
//         return new TopicExchange("TestTopicExchange");
//     }
//
//     @Bean
//     public Queue firstQueue() {
//         return new Queue("TestTopicQueue1");
//     }
//
//     @Bean
//     public Queue secondQueue() {
//         return new Queue("TestTopicQueue2");
//     }
//
//
//     // 将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
//     // 这样只要是消息携带的路由键是topic.man,才会分发到该队列
//     @Bean
//     Binding bindingExchangeMessage() {
//         return BindingBuilder.bind(firstQueue()).to(exchange()).with("topic.man");
//     }
//
//     // 将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
//     // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
//     @Bean
//     Binding bindingExchangeMessage2() {
//         return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
//     }
//
// }