package com.woniu.subpub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.woniu.util.RabbitMQUtil;
import org.omg.CORBA.INTERNAL;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Ticket {
//  发布者
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
//      生产者不再与队列进行交互，而是直接与交换机交互，将消息投递给exchange（交换机）
//      参数1：交换机名称，暂时不用
//      参数2：队列名称
//      参数3：额外参数
//      参数4：发布的消息
        for (int i=0;i<100;i++){
            channel.basicPublish("subpub_exchange","",null,("票务信息"+i).getBytes());
        }
        channel.close();
        connection.close();
    }
}
