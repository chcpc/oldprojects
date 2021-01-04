package com.woniuxy.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.pojo.Informations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class InformationsServiceTest {
    @Autowired
    InformationsService informationsService;
    @Test
    public void  queryByPage(){
        List<Informations> list = informationsService.queryByPage(1,5);
        PageInfo<Informations> pageInfo = new PageInfo<>(list);
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("首页:"+pageInfo.getNavigateFirstPage());
        System.out.println("末页:"+pageInfo.getNavigateLastPage());
        for(Informations info:list){
            System.out.println(info);
        }
    }
    @Test
    public void getInfoAndAddViewById(){
        System.out.println(informationsService.getInfoAndAddViewById(1));
    }
}