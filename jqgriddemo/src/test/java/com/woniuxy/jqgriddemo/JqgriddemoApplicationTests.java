package com.woniuxy.jqgriddemo;

import com.woniuxy.jqgriddemo.dao.BaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//一定要添加该注解才能运行
@SpringBootTest
public class JqgriddemoApplicationTests {

    @Autowired
    BaseMapper baseMapper;
    @Test
    public void contextLoads() {
        String s1 = "status";
        String s2 = "is null";
        System.out.println(baseMapper.selectAll(s1,s2));
    }

}
