package com.bou.wyj.config;
 
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class DelayQueueConfig {
    // 1.创建正常队列交换机与私信交换机与队列
    public static final String NOR_QUEUE = "norQueue";   // 普通队列
    public static final String NOR_EXCHANGE = "normalExchange";   // 普通交换机
    public static final String DLX_QUEUE = "dlxQueue";   // 死信队列
    public static final String DLX_EXCHANGE = "dlxExchange";   // 死信交换机
    public static final String DLX_ROUTING_KEY = "dlx";  // 死信队列路由
    public static final String NOR_ROUTING_KEY = "normal";  // 普通队列路由
    public static final Integer TTL_TIME  = 10000*180;  // 延迟时间

    @Bean
    public DirectExchange normalExchange() {
        // 创建普通交换机
        return ExchangeBuilder.directExchange(NOR_EXCHANGE).build();
    }
    @Bean
    public Binding bindingNor(@Qualifier("norQueue")Queue norQueue,@Qualifier("normalExchange")DirectExchange norEx) {
        // 将普通队列与普通交换机绑定
        return BindingBuilder.bind(norQueue).to(norEx).with(NOR_ROUTING_KEY);
    }
    @Bean
    public Queue dlxQueue() {
        // 创建死信队列
        return QueueBuilder.durable(DLX_QUEUE).build();
    }

    @Bean
    public DirectExchange dlxEx() {
        // 创建死信交换机
        return ExchangeBuilder.directExchange(DLX_EXCHANGE).build();
    }
    @Bean
    public Binding bindingDLX(@Qualifier("dlxQueue") Queue dlxQueue,@Qualifier("dlxEx")DirectExchange dlxEx) {
        // 将死信队列与死信交换机绑定
        return BindingBuilder.bind(dlxQueue).to(dlxEx).with(DLX_ROUTING_KEY);
    }
    @Bean
    public Queue norQueue(){
        // 创建普通队列绑定死信交换机与发送到死信队列的路由
        return QueueBuilder.durable(NOR_QUEUE)
                .ttl(TTL_TIME)
                .deadLetterExchange(DLX_EXCHANGE).deadLetterRoutingKey(DLX_ROUTING_KEY).build();
    }


 


 
}