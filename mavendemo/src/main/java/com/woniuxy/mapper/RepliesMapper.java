package com.woniuxy.mapper;

import com.woniuxy.pojo.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepliesMapper {
    List<Replies> selectRepliesByInfold(@Param("infold") Integer infold);

    int deleteByPrimaryKey(Integer id);

    int insert(Replies record);

    int insertSelective(Replies record);

    Replies selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Replies record);

    int updateByPrimaryKey(Replies record);
//  新增
    void insertRepy(@Param("replies")Replies replies);
}