package com.woniuxy.service;

import com.woniuxy.pojo.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepliesService {

    List<Replies> getRepliesByInfold(Integer infold);
//  新增replies表并修改information表
    void addReplyAndAddreplyCount(Replies replies);
}
