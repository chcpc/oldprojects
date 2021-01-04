package com.woniu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue() {
        Set set = new HashSet();
        set.add("192.168.109.131:26379");
        set.add("192.168.109.131:26380");
        set.add("192.168.109.131:26381");
        JedisSentinelPool pool = new JedisSentinelPool("mymaster",set);

        for (int i = 0;; i++) {
                Jedis jedis = null;
            try {
                jedis = pool.getResource();
                jedis.set("key-"+i,"value-"+i);
                System.out.println("set--->"+i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(jedis != null){
                    jedis.close();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }







    }
}
