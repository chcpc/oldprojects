package com.woniuxy.mapper;

import com.woniuxy.pojo.Replies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class RepliesMapperTest {
    @Autowired
    RepliesMapper repliesMapper;

    @Test
    public void selectRepliesByInfold() {
        System.out.println(repliesMapper.selectRepliesByInfold(1));
    }
    @Test
    public void insertReply() {
        Replies replies = new Replies();
        replies.setContent("测试赛");
        replies.setInfold(1);
        repliesMapper.insertRepy(replies);
    }
}