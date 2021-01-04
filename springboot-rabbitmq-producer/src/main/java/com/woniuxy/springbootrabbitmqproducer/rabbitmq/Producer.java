package com.woniuxy.springbootrabbitmqproducer.rabbitmq;

import com.woniuxy.springbootrabbitmqproducer.pojo.Msg;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//配置Component
@Component
public class Producer {
    @Autowired
    RabbitTemplate rabbitTemplate;
//  发送消息的方法
    public void sendMsg(Msg msg){
//      获取附加参数，即指定消息id
        CorrelationData data = new CorrelationData();
        data.setId(msg.getId().toString());
//      convertAndSend：转换并发送
//      参数1：交换机名称
//      参数2：路由key
//      参数3：信息内容
        rabbitTemplate.convertAndSend("springboot-exchange","msg",msg,data);
//      参数4：附加参数，将data填入
    }
}
