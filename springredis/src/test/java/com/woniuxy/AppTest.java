package com.woniuxy;

import static org.junit.Assert.assertTrue;


import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.woniuxy.pojo.Emp;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.event.TransactionalEventListener;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AppTest 
{
    @Autowired
    private RedisTemplate redisTemplate;
//  String序列化对象和基本数据类型
    @Test
    public void shouldAnswerWithTrue(){
        //JDK的方式进行序列化
//      以最基础的方式存储String类型数据<K V>=<String String>
        redisTemplate.opsForValue().set("str","hello");
        Emp emp = new Emp();
        emp.setEmpno(1001);
        emp.setEname("hello");
        emp.setHiredate(new Date());
//      同时，该方法中的参数也可以使object对象，传递方式为json
        redisTemplate.opsForValue().set("emp",emp);// {empno:1001,ename:'hello'}
    }
//  反序列化
    @Test
    public void testDeserializable(){
//      反序列化操作获取redis库中的数据
        Emp emp = (Emp)redisTemplate.opsForValue().get("emp");
        System.out.println(emp.getHiredate());
    }

//  使用List
    @Test
    public void testList(){
//      存储List到Value当中
        List list = new ArrayList();
        list.add(new Emp(1001,"hello1",new Date()));
        list.add(new Emp(1002,"hello2",new Date()));
        list.add(new Emp(1003,"hello3",new Date()));
        redisTemplate.opsForValue().set("emps",list);
//      获取并输出
        List<Emp> emps = (List<Emp>) redisTemplate.opsForValue().get("emps");
        for (Emp emp : emps) {
            System.out.println(emp.getEname());
        }
    }
//  在List中存储String
    @Test
    public void testForList(){
//      将mylist集合存储到redis当中
        redisTemplate.opsForList().rightPush("mylist","a");
        redisTemplate.opsForList().rightPush("mylist","b");
        redisTemplate.opsForList().rightPush("mylist","c");
        redisTemplate.opsForList().rightPush("mylist","c");
//      取出集合所有内容
        List<String> list = redisTemplate.opsForList().range("mylist",0,-1);
        for(String s : list){
            System.out.println(s);
        }
    }
//  在List中存储对象
    @Test
    public void testOpsForList(){
        Emp emp1 = new Emp();
        emp1.setEmpno(1);
        emp1.setEname("za");
        emp1.setHiredate(new Date());
        Emp emp2 = new Emp();
        emp2.setEmpno(2);
        emp2.setEname("zs");
        emp2.setHiredate(new Date());
//      序列化
        redisTemplate.opsForList().rightPush("EmpList",emp1);
        redisTemplate.opsForList().rightPush("EmpList",emp2);
//      反序列化
        List<Emp> list = redisTemplate.opsForList().range("EmpList",0,-1);
        for(Emp e : list){
            System.out.println(e);
        }

    }
//  使用Hash
    @Test
    public void testHash() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//      创建Map
        Map map = new HashMap<>();
        map.put("ename","hello1");
        map.put("empno",20);
        map.put("hiredate",new Date());
//      创建对象
        Emp emp = new Emp();
        emp.setHiredate(new Date());
        emp.setEname("hello");
        emp.setEmpno(1001);
//      将对象转化为man
        Map empMap =  BeanUtils.describe(emp);
        System.out.println("empMap:"+empMap);
//      putAll取代一个个放置的put方法
        redisTemplate.opsForHash().putAll("user:1002",empMap);
        // redisTemplate.opsForHash().put("user:1001","name","hello");
//      反序列化
//      使用方法entries()直接获取Map结果
        Map result = redisTemplate.opsForHash().entries("user:1002");
        System.out.println("result:"+result);

        Emp e = new Emp();

        RedisOperations operations =  redisTemplate.opsForHash().getOperations();


        //注册日期转换期
        /*ConvertUtils.register(new Converter() {
            @Override
            public <Date> Date convert(Class<Date> aClass, Object o) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return (Date) simpleDateFormat.parse((String) o);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        },Date.class);
        BeanUtils.populate(e,result);*/
        BeanUtils.copyProperty(e,"hiredate",map.get("hiredate"));
        System.out.println("hiredate:"+e.getHiredate());
    }
}
