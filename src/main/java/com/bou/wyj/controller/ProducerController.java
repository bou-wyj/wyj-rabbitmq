package com.bou.wyj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/producer")
@Api(tags = "生产者模块")
public class ProducerController {
 
    @Resource
    RabbitTemplate rabbitTemplate;
 
    @GetMapping("/sendDirectMessage")
    @ApiOperation(value = "发送直接消息")
    @ApiOperationSupport(order = 1)
    public String sendDirectMessage(@RequestParam String msg){
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting",msg);
        return "ok";
    }

    @GetMapping("/sendTopicMessage1")
    @ApiOperation(value = "发送主题消息man")
    @ApiOperationSupport(order = 2)
    public String sendTopicMessage1() {
        rabbitTemplate.convertAndSend("TestTopicExchange", "topic.man", "推送消息，路由键为topic.man");
        return "ok";
    }

    @GetMapping("/sendTopicMessage2")
    @ApiOperation(value = "发送主题消息woman")
    @ApiOperationSupport(order = 3)
    public String sendTopicMessage2() {
        rabbitTemplate.convertAndSend("TestTopicExchange", "topic.woman", "推送消息，路由键为topic.woman");
        return "ok";
    }

    @GetMapping("/sendFanoutMessage")
    @ApiOperation(value = "发送扇出消息")
    @ApiOperationSupport(order = 4)
    public String sendFanoutMessage() {
        rabbitTemplate.convertAndSend("TestFanoutExchange", null, "推送消息");
        return "ok";
    }

    @GetMapping("/sendDelayMessage")
    @ApiOperation(value = "发送延迟消息")
    @ApiOperationSupport(order = 5)
    public String sendDelayMessage(String orderId) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //等价于now.toLocaleString()
        String date = dateFormat.format(new Date());
        System.out.println("消息：" + orderId +" 生产时间（"+  date +"）");
        rabbitTemplate.convertAndSend("normalExchange", "normal", orderId);
        return date;
    }
}