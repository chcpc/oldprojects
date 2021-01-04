package com.woniu.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
//  从工具类获取连接
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtil.getConnection();
//      获取channel
        Channel channel = connection.createChannel();
//      声明一个队列
//      参数1：队列名称
//      参数5：额外参数
        channel.queueDeclare("work_queue",false,false,false,null);
//      发送消息
//      参数1：交换机名称，暂时不用
//      参数2：队列名称
//      参数3：额外参数
//      参数4：发布的消息
        for(int i=0;i<100;i++){
            channel.basicPublish("","work_queue",null,new String("msg-->"+i).getBytes());
        }
        channel.close();
        connection.close();
    }

}
