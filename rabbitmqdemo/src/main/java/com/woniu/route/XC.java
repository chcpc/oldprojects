package com.woniu.route;

import com.rabbitmq.client.*;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;

public class XC {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        final Channel channel = connection.createChannel();
//      声明队列
        channel.queueDeclare("xc_queue",false,false,false,null);
//      将队列和交换机绑定并设定路由key
//      参数1：队列名称
//      参数2：交换机名称
//      参数3：路由器的key
        channel.queueBind("xc_queue","route_exchange","schk.20001001.001");
        channel.queueBind("xc_queue","route_exchange","schk.20001001.002");
//      接收消息
        channel.basicConsume("xc_queue",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                channel.basicAck(envelope.getDeliveryTag(),false);
                System.out.println("携程消费消息："+new String(body));
            }
        });
    }
}
