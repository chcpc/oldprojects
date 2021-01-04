package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.ProductParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductParamMapperTests {
    @Autowired
    ProductParamMapper productParamMapper;
    @Test
    public void selectProductCoverById() {

        System.out.println(productParamMapper.selectProductParamByProductId(900));
    }

}
