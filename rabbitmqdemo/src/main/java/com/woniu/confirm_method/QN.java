package com.woniu.confirm_method;

import com.rabbitmq.client.*;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;

public class QN {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        final Channel channel = connection.createChannel();
//      设定队列信息
        channel.queueDeclare("qn_queue",false,false,false,null);
//      将队列和交换机绑定
//      参数1：队列名称
//      参数2：交换机名称
//      参数3：路由的key，topic模式下可以使用通配符
        channel.queueBind("qn_queue","topic_exchange","xmhk.20001002.*");
//      接收消息
        channel.basicConsume("qn_queue",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("携程："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
//                channel.basicNack(hashCode(), false, false);
            }
        });
    }
}
