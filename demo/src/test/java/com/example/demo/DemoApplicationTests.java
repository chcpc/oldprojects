package com.example.demo;

import com.example.demo.mapper.StandardMapper;
import com.example.demo.pojo.Standard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private StandardMapper standardMapper;
    @Test
    public void contextLoads() {
        List<Standard> list = standardMapper.queryStandardsPyPage(1,5,"GB");
        for (Standard standard: list) {
            System.out.println(standard.getZhname());
        }

    }

}
