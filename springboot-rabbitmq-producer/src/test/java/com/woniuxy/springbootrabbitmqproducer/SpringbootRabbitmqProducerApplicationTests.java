package com.woniuxy.springbootrabbitmqproducer;

import com.woniuxy.springbootrabbitmqproducer.pojo.Msg;
import com.woniuxy.springbootrabbitmqproducer.rabbitmq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqProducerApplicationTests {
    @Autowired
    private Producer producer;
    @Test
    public void contextLoads() {
        Msg msg = new Msg();
        msg.setId(1);
        msg.setTitle("发送消息");
        msg.setCreateTime(new Date());
        producer.sendMsg(msg);
    }

}
