package com.woniu.work;

import com.rabbitmq.client.*;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;

public class Consumer3 {
    public static void main(String[] args) throws IOException {
        //  从工具类获取连接
        Connection connection = RabbitMQUtil.getConnection();
//      创建频道
        final Channel channel = connection.createChannel();
//      声明一个队列
//      参数1：消息队列名称
        channel.queueDeclare("work_queue",false,false,false,null);
//      设置为签收模式
        channel.basicQos(1);//设置为1，即签收一个，处理一个
//      接收信息
        channel.basicConsume("work_queue",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者3消费消息："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
