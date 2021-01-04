package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.woniuxy.rabbitmq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private Producer producer;
    @Test
    public void shouldAnswerWithTrue()
    {
        Map<String, String> map = new HashMap();
        for (int i=0;i<100;i++){
        map.put("schk.20001001.001","北京-成都航班信息"+i);
            producer.SendMsg("schk.2000",map);
        }

        System.out.println("ok");
    }
}
