package com.woniuxy.springbootrabbitmqconsumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.woniuxy.springbootrabbitmqproducer.pojo.Msg;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


/**
 * consumer：消费者类
 *  配置接收消息的方法
 */
@Component
public class Consumer {
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "msg_queue",declare = "true"),
//            exchange = @Exchange(name = "springboot-exchange",declare = "true",type = "topic"),
//            key = "#"
//    ))
//    @RabbitHandler   //  该注解用来标记这是一个消费者处理消息的方法
//    public void recv(@Payload Msg msg, Channel channel, @Headers Map headers){
//       //   @PayLoad用来标记是传递的消息，将消息反序列化为对象并将其注入给PayLoad注解标记的方法参数
//       //   @Headers用来标记为消息头
//       System.out.println("消费者接收："+msg.getTitle()+"->"+msg.getCreateTime());
////     消息id
//       Long tag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
//       try {
////         手动编程的方式签收
//           channel.basicAck(tag,false);
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
        @RabbitListener(bindings = @QueueBinding(
                value = @Queue(name = "msg_queue",declare = "true"),
                exchange = @Exchange(name = "springboot-exchange",declare = "true",type = "topic"),
                key = "#"
        ))
        @RabbitHandler   //  该注解用来标记这是一个消费者处理消息的方法
        public void recv(@Payload Msg msg, Channel channel, @Headers Map headers){
            //   @PayLoad用来标记是传递的消息，将消息反序列化为对象并将其注入给PayLoad注解标记的方法参数
            //   @Headers用来标记为消息头
            System.out.println("消费者接收："+msg.getTitle()+"->"+msg.getCreateTime());
            //   消息id
            Long tag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            try {
//         手动编程的方式签收
                channel.basicAck(tag,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
   }
}


