package com.woniuxy.redisproject.rabbitmq;

import com.rabbitmq.client.Channel;
import com.woniuxy.redisproject.dao.OrderMapper;
import com.woniuxy.redisproject.pojo.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 配置消费者类
 */
@Component
public class OrderConsumer {


    @Autowired
    private OrderMapper orderMapper;


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name="order_queue"),
                    exchange = @Exchange(name="order_exchange",type = "fanout")
            )
    })
    @RabbitHandler
    public void handlerOrder(@Payload Map map, Channel channel, @Headers  Map headers ){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      将用户信息写入到订单中
        Integer userId = (Integer) map.get("userId");
        String orderNo = (String) map.get("orderNo");
        Order order = new Order();
        order.setOrderSn(orderNo);
        order.setCreateTime(new Date());
        order.setStatus(0);
        order.setDeleteStatus(0);
        order.setReceiverName("hello");
        order.setReceiverPhone("13588889999");
        order.setMemberId(userId.longValue());
        orderMapper.insertSelective(order);
//      获取消息头，并返回确认
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(tag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
