package com.bou.wyj.consumer.delay;
 
import com.bou.wyj.config.DelayQueueConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DelayConsumer {
    @RabbitListener(queues = DelayQueueConfig.DLX_QUEUE)
    public void delay(String message) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        System.out.println("消息：" + message +" 消费时间（"+  date +"）");
    }
}