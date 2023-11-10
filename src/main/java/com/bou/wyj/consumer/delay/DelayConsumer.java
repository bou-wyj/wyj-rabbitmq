package com.bou.wyj.consumer.delay;
 
import com.bou.wyj.config.DelayQueueConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
@Component
public class DelayConsumer {
    @RabbitListener(queues = DelayQueueConfig.DLX_QUEUE)
    public void delay(Message message) {
        System.out.println("获取到订单，" + message.getBody() + "查询数据库是否已支付？未支付则回滚");
    }
}