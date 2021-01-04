package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    @Select("SELECT * FROM t_comment WHERE product_id=#{product_id}")
    List<Comment> selectCommentByProductId(Integer id);
}