package com.woniu.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/27
 */
public class Consumer {
//  消费者
    public static void main(String[] args) throws IOException, TimeoutException {
//      同样创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
//      设置主机和端口
        factory.setHost("192.168.109.131");
        factory.setPort(5672);
//      设置用户名和密码
        factory.setUsername("admin");
        factory.setPassword("admin");
//      设置虚拟主机
        factory.setVirtualHost("/test");

//      获取连接，通过连接工厂获取
        Connection connection = factory.newConnection();
        //创建通道
        final Channel channel = connection.createChannel();
        channel.queueDeclare("simple_queue",false,false,false,null);

        //参数2：false表示手动编程的方式签收，true表示自动签收。
        channel.basicConsume("simple_queue",new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //签收消息
                //参数1：签收消息的Id
                //参数2： false表示只签收当前消息，true表示签收所有未签收的消息
                channel.basicAck(envelope.getDeliveryTag(),true);
                System.out.println("消费的消息："+new String(body));
            }
        });

    }
}
