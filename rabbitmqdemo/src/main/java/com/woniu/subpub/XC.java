package com.woniu.subpub;

import com.rabbitmq.client.*;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;

public class XC {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        final Channel channel = connection.createChannel();
//      声明消息队列
//      参数1：队列名称
        channel.queueDeclare("xc_queue",false,false,false,null);
//      将队列与交换机进行绑定
//      参数3：路由器的key，暂时不用
        channel.queueBind("xc_queue","subpub_exchange","");
//      接收消息
        channel.basicConsume("xc_queue",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("携程处理消息："+new String(body));
//              确认接收
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
