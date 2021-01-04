package com.woniu.route;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.woniu.util.RabbitMQUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Ticket {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        Map<String, String> map = new HashMap();
        map.put("schk.20001001.001","成都-北京航班信息20001001");
        map.put("schk.20001001.002","成都-上海航班信息20001001");
        map.put("schk.20001001.003","成都-广州航班信息20001001");
        map.put("schk.20001001.004","成都-海南航班信息20001001");
        map.put("schk.20001002.001","成都-北京航班信息20001002");
        map.put("schk.20001002.002","成都-上海航班信息20001002");
        map.put("xmhk.20001002.001","成都-广州航班信息20001002");
        map.put("xmhk.20001002.002","成都-海南航班信息20001002");
//      遍历发送消息
//      参数1：交换机名称，暂时不用
//      参数2：队列名称
//      参数3：额外参数
//      参数4：发布的消息
        for (Map.Entry<String, String> entry : map.entrySet()){
            channel.basicPublish("route_exchange",entry.getKey(),null,entry.getValue().getBytes());
        }
        channel.close();
        connection.close();
    }
}
