package com.woniu.pmsdemo.dao;

import com.woniu.pmsdemo.pojo.Comment;
import com.woniu.pmsdemo.pojo.ProductCover;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);


    @Select("select * from t_comment where product_id = #{id}")
    List<Comment> queryByProductId(Integer id);
}