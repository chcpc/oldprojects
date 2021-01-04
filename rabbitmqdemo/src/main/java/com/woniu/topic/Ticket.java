package com.woniu.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
//      参数1：交换机名称
//      参数2：队列名称
//      参数3：额外参数
//      参数4：发布的消息
        for (Map.Entry<String, String> entry : map.entrySet()){
            channel.basicPublish("topic_exchange",entry.getKey(),null,entry.getValue().getBytes());
        }
        channel.close();
        connection.close();

    }
}
