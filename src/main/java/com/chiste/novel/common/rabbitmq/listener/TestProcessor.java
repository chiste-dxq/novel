package com.chiste.novel.common.rabbitmq.listener;

import com.chiste.novel.common.rabbitmq.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
 * @Author: daixq
 * @Date: 2021/7/20 16:07
 * @Description:
 **/
@Slf4j
@EnableRabbit
@Component
public class TestProcessor {

    @RabbitListener(autoStartup = "#{environment['spring.rabbitmq.open']}", bindings = {
            @QueueBinding(value = @Queue(value = RabbitMQConstant.DELAY_MSG_QUEUE),
                    exchange = @Exchange(value = RabbitMQConstant.DELAY_MSG_EXCHANGE, autoDelete = "false", delayed = "true"),
                    key = RabbitMQConstant.DELAY_MSG_KEY)
    })
    public void processor(String jsonMsg) {
        System.out.println("repeatTradeQueue 接收时间:"+ LocalDateTime.now().toString()+" 接收内容:"+ jsonMsg);
    }

}
