package com.bou.wyj.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

@Slf4j
@Configuration
public class ErrorMessageConfig {
 
    @Bean
    public DirectExchange errorMessageExchange(){
        return new DirectExchange("error.direct");
    }
 
    @Bean
    public Queue errorQueue(){
        return new Queue("error.queue", true);
    }
 
    @Bean
    public Binding errorMessageBinding(){
        return BindingBuilder.bind(errorQueue()).to(errorMessageExchange()).with("e");

    }
 
    // 失败后将消息投递到一个指定的，专门存放异常消息的队列，后续由人工集中处理。
    @Bean
    public MessageRecoverer republishMessageRecoverer(RabbitTemplate rabbitTemplate){
        return new RepublishMessageRecoverer(rabbitTemplate, "error.direct", "e");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(name = "error.queue", durable = "true"),
            exchange = @org.springframework.amqp.rabbit.annotation.Exchange(name = "error.direct", type = ExchangeTypes.DIRECT),
            key = "e"
    ))
    public void listenErrorQueue(String msg) {
        //重试失败后，需要用户重新授权
        log.info("失败信息接收成功:{}", msg);
    }
}