package com.woniu.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/27
 */
public class Producer {
//  生产者
    public static void main(String[] args) throws IOException, TimeoutException {
//      创建rabbit连接工厂，并配置信息
        ConnectionFactory factory = new ConnectionFactory();

//      设置主机和端口
        factory.setHost("192.168.109.131");
        factory.setPort(5672);
//      设置用户和密码
        factory.setUsername("admin");
        factory.setPassword("admin");
//      设置虚拟主机
        factory.setVirtualHost("/test");

//      获取连接，通过工厂
        Connection connection = factory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();

        //声明一个队列：有则直接使用，没有则创建
        //参数1：队列的名称
        //参数2：是否对消息数据进行持久化
        //参数3：是否私有化，false表示所有的消费者都可以访问，true表示只有第一次拥有该消息的消费者才可以访问
        //参数4：是否自动删除，连接关闭后是否自动删除队列
        //参数5：其他额外的参数。
        channel.queueDeclare("simple_queue",false,false,false,null);

//      发送消息
        //参数1： 是交换机的名称，暂时不用
        //参数2：队列名称
        //参数3：额外参数
        //参数4： 发布的消息
        channel.basicPublish("","simple_queue",null,"hello rabbitmq".getBytes());

//      关闭流
        channel.close();
        connection.close();
        System.out.println("ok");
    }
}
