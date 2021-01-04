package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    ProductMapper productMapper;
    @Test
    public void selectById() {
        System.out.println(productMapper.selectByPrimaryKey(867));
    }

}
