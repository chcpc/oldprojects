package com.woniu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static synchronized Jedis getJedis(){
        Jedis jedis = new Jedis("192.168.109.131",6666);
        jedis.auth("123456");
        return jedis;
    }
    @Test
    public void testString(){
        //
        Jedis jedis = getJedis();
//        flush为刷新数据库
//        jedis.flushDB();
        jedis.set("str","hello redis"); //
        jedis.expire("str",5);
        jedis.mset(new String[]{"a","b","c","d","e","f"});
        Long result = jedis.del("str");
        System.out.println("result:"+result);
//      mget：输入String数组，返回集合
        List<String> list = jedis.mget(new String[]{"a","c"});
        List<String> list2 = jedis.mget(new String[]{"e"});
        for(String s : list){
            System.out.println("-->"+s);
        }
        System.out.println("show："+list2.get(0));
        String value = jedis.get("str");
        jedis.set("count","100");
        jedis.decr("count");
        System.out.println("incr:"+jedis.incr("count"));
        jedis.decrBy("count",10);
        System.out.println("uncrby:"+jedis.incrBy("count",10));
        jedis.expire("sts",5);
        System.out.println(jedis.ttl("sts"));
        try {
            Thread.sleep(3000);
        }catch(Exception e){

        }
        System.out.println(jedis.ttl("sts"));
        jedis.del("sts");
        //  一旦关闭连接，则无法获取值，返回的值为null。
        jedis.close();
        System.out.println(value);
    }


    @Test
    public void testHash(){
        Jedis jedis = getJedis();
        jedis.hset("user:1001","name","hello");
        jedis.hset("user:1001","age","20");
        jedis.hset("user:1001","sex","男");

        String value = jedis.hget("user:1001","name");
//      hmget：输入key和field的String数组，获取List
        List<String> result = jedis.hmget("user:1001",new String[]{"name","age"});
        for (String s : result) {
            System.out.println("-->"+s);
        }
//      hgetall：输入key获取所有的属性及其值
        Map<String,String> map = jedis.hgetAll("user:1001");
        for(Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();it.hasNext();){
            Map.Entry<String,String> entry = it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        jedis.close();
        System.out.println(value);
    }

    @Test
    public void testList(){
        Jedis jedis = getJedis();
//      3.List：
        System.out.println("------3.List类型------");
//      3.1添加
        System.out.println("---3.1添加---");
        System.out.println("rpush：从右侧开始添加");
        jedis.rpush("mylist",new String[]{"c"});
        System.out.println("lpush：从左侧开始添加");
        jedis.lpush("mylist",new String[]{"a"});

//      3.2获取并移除某侧的第一个元素
        System.out.println("---3.2获取并移除---");
//      lpop：从左侧移除
        String lvalue = jedis.lpop("mylist");
        System.out.println(lvalue);
//      rpop：从右侧移除
        String rvalue = jedis.rpop("mylist");
        System.out.println(rvalue);
//      3.3获取集合长度
        System.out.println("---3.3获取集合长度---");
        System.out.println("length:"+jedis.llen("mylist"));
//      3.4获取指定下标范围的所有元素
        System.out.println("---3.4获取指定下标范围的所有元素---");
        List<String> newList = jedis.lrange("mylist",0,-1);
        for (String s : newList) {
            System.out.println(s);
        }
        jedis.close();
    }


    @Test
    public void testSet(){
        Jedis jedis = getJedis();
//      4.Set：无序去重
        System.out.println("------4.Set类型------");
        System.out.println("---4.1添加---");
//      4.1添加
        System.out.println("sadd：执行添加");
        jedis.sadd("myset",new String[]{"a","b","c","e"});
//      smembers：获取集合中的所有元素
        System.out.println("smembers：获取集合中的所有元素");
        Set<String> set = jedis.smembers("myset");
        for (String s : set) {
            System.out.println(s);
        }
//      4.2移除
        System.out.println("---4.2移除---");
//      srem：移除目标集合中指定的keys
        System.out.println("srem：移除目标集合中指定的keys");
        System.out.println("scard：查看成员数量："+jedis.scard("myset"));
//      去掉myset中的key：a
        jedis.srem("myset","a");
        System.out.println("scard：成员数量："+jedis.scard("myset"));
        System.out.println("已经去掉myset中的key：a");
//      4.3交集
        System.out.println("---4.3交集---");
//      获取两个指定集合的交集
        System.out.println("sinter：获取交集");
        jedis.sadd("myset1",new String[]{"d","b","c"});
        Set<String> myset = jedis.sinter("myset","myset1");
        for (String s : myset) {
            System.out.println("交集："+s);
        }
        //      4.4交集
        System.out.println("---4.4并集---");
//      获取两个指定集合的并集
        System.out.println("sunion：获取并集");
        Set<String> sunion = jedis.sunion("myset","myset1");
        for(String s: sunion){
            System.out.println("并集："+s);
        }
//      4.5单一差集
        System.out.println("---4.5单一差集---");
//      获取两个指定集合的不同的部分
        System.out.println("sdiff：获取不同");
        Set<String> sdiff1 = jedis.sdiff("myset","myset1");
        for(String s: sdiff1){
            System.out.println("myset相对myset1的不同部分："+s);
        }
        Set<String> sdiff2 = jedis.sdiff("myset1","myset");
        for(String s: sdiff2){
            System.out.println("myset1相对myset的不同部分："+s);
        }
//      4.6单一差集
        System.out.println("---4.6随机获取---");
        System.out.println(jedis.srandmember("myset"));
        System.out.println(jedis.srandmember("myset"));
        System.out.println(jedis.srandmember("myset"));
        jedis.close();
    }

    @Test
    public void testZSet(){
        Jedis jedis = getJedis();
//      5.ZSet
        System.out.println("------5.ZSet------");
//      5.1添加
        System.out.println("---5.1添加---");
//      zadd：查看
        System.out.println("zadd:添加");
        jedis.zadd("myscore",89D,"zs");
        jedis.zadd("myscore",85D,"lisi");
        jedis.zadd("myscore",69D,"ww");
        jedis.zadd("myscore",79D,"hello");
        jedis.zadd("myscore",99D,"zz");
//      5.2查看成员数量
        System.out.println("---5.2查看成员数量---");
        System.out.println("zcard：查看成员数量");
        System.out.println(jedis.zcard("myscore"));
//      5.3查看ZSet中按score排序的所有元素
        System.out.println("---5.3查看ZSet中按score排序的所有元素---");
        Set<String> set = jedis.zrange("myscore",0,-1);
        for (String s : set) {
            System.out.println(s);
        }
//      5.4查看ZSet中指定score范围内的元素
        System.out.println("---5.4查看ZSet中按score排序的所有元素---");
//      zrangeByScore：按score排序的所有元素
        System.out.println("zrangeByScore：按score排序的所有元素");
        Set<String> scoreSet = jedis.zrangeByScore("myscore",80D,100D);
        for (String s : scoreSet) {
            System.out.println("-->"+s);
        }
//      5.5查看指定元素的score排序值
        System.out.println("---5.5查看指定元素的score排序值---");
//      zrank：查看指定元素的score排序值
        System.out.println("zrank：查看指定元素的score排序值");
        Long index = jedis.zrank("myscore","zs");
        System.out.println("index:"+index);
//      5.查看指定score范围内的所有元素及其score
        System.out.println("---5.查看指定score范围内的所有元素及其score---");
//      zrangeWithScores：查看指定score范围内的所有元素及其score
        System.out.println("zrangeWithScores：查看指定score范围内的所有元素及其score");
        Set<Tuple> myset = jedis.zrangeWithScores("myscore",0,-1);
        for (Tuple tuple : myset) {
            System.out.println(tuple.getScore()+":"+tuple.getElement());
        }
        jedis.close();
    }











}
