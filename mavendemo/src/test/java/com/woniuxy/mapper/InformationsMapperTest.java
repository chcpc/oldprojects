package com.woniuxy.mapper;

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
public class InformationsMapperTest {
    @Autowired
    private InformationsMapper informationsMapper;
    @Test
    public void InformationQueryByPage(){
//        select limit
//        select count(*)
        List<Informations> list = informationsMapper.InformationQueryByPage(1,5);
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
    public void getInformationsById(){
//        select limit
//        select count(*)
        Informations info = informationsMapper.selectByPrimaryKey(1);

        System.out.println(info);
    }
    @Test
    public void addviewCountByPrimaryKey(){
        informationsMapper.addviewCountByPrimaryKey(1);
    }
    @Test
    public void addreplyCountByPrimaryKey(){
        informationsMapper.addreplyCountByPrimaryKey(1);
    }
}