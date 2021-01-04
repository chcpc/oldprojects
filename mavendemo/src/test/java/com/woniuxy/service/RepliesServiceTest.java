package com.woniuxy.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.pojo.Informations;
import com.woniuxy.pojo.Replies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class RepliesServiceTest {
    @Autowired
    RepliesService repliesService;
    @Test
    public void  queryByInfold(){
        System.out.println(repliesService.getRepliesByInfold(1));
    }
    @Test
    public void  addReplyAndAddreplyCountTest(){
        Replies replies = new Replies();
        replies.setContent("测试赛2");
        replies.setInfold(1);
        repliesService.addReplyAndAddreplyCount(replies);
    }
}