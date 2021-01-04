package com.woniu.confirm_method;

import com.rabbitmq.client.*;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Ticket {
    public static void main(String[] args) throws IOException, TimeoutException {
//      从工具类获取连接
        Connection connection = RabbitMQUtil.getConnection();
//      创建频道
        Channel channel = connection.createChannel();
//      开启确认机制
        channel.confirmSelect();
//      Confirm监听
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("消息已经被broker接收"+l);
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("消息已经被broker拒收"+l);
            }
        });
//      Return监听
        channel.addReturnListener(new ReturnCallback() {
            @Override
            public void handle(Return r) {
                System.out.println("返回编码："+r.getReplyCode());
                System.out.println("返回原因："+r.getReplyText());
                System.out.println("路由key："+r.getRoutingKey());
                System.out.println("交换机："+r.getExchange());
                System.out.println("消息："+new String(r.getBody()));
            }
        });
//      设定信息
        Map<String, String> map = new HashMap();
        map.put("schk.20001001.001","成都-北京航班信息20001001");
        map.put("schk.20001001.002","成都-上海航班信息20001001");
        map.put("schk.20001001.003","成都-广州航班信息20001001");
        map.put("schk.20001001.004","成都-海南航班信息20001001");
        map.put("schk.20001002.001","成都-北京航班信息20001002");
        map.put("schk.20001002.002","成都-上海航班信息20001002");
        map.put("xmhk.20001002.001","成都-广州航班信息20001002");
        map.put("xmhk.20001002.002","成都-海南航班信息20001002");
        map.put("xmhk.20001003.001","成都-广州航班信息20001003");
        map.put("xmhk.20001003.002","成都-海南航班信息20001003");
//      参数1：交换机名称
//      参数2：队列名称
//      参数3：额外参数
//      参数4：发布的消息
        for (Map.Entry<String, String> entry : map.entrySet()){
//          ************* true
//          添加参数true，使得未能找到接收对象的消息可以反馈回来
            channel.basicPublish("topic_exchange",entry.getKey(),true,null,entry.getValue().getBytes());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        channel.close();
//        connection.close();

    }
}
