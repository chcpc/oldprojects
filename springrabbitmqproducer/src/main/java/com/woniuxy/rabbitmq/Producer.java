package com.woniuxy.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Qualifier(value = "producer")
public class Producer {
    @Autowired
    public RabbitTemplate rabbitTemplate;
    public void SendMsg(String key, Map map){
        rabbitTemplate.convertAndSend(key,map);
        System.out.println("发送完毕");
    }
}

