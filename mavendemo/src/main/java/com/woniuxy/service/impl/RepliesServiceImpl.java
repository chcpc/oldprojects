package com.woniuxy.service.impl;

import com.woniuxy.mapper.InformationsMapper;
import com.woniuxy.mapper.RepliesMapper;
import com.woniuxy.pojo.Informations;
import com.woniuxy.pojo.Replies;
import com.woniuxy.service.InformationsService;
import com.woniuxy.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepliesServiceImpl implements RepliesService {
    @Autowired
    RepliesMapper repliesMapper;
    @Autowired
    private InformationsMapper informationsMapper;

    @Override
    public List<Replies> getRepliesByInfold(Integer infold) {
        return repliesMapper.selectRepliesByInfold(infold);
    }

    //    @Transactional
    @Override
    public void addReplyAndAddreplyCount(Replies replies) {
        //  新增到replies表
        repliesMapper.insertRepy(replies);
        //  修改informations表回复次数
        informationsMapper.addreplyCountByPrimaryKey(replies.getInfold());
    }
}
