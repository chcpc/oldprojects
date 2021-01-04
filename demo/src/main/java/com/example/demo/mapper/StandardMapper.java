package com.example.demo.mapper;

import com.example.demo.pojo.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface StandardMapper {
//    分页查询
    List<Standard> queryStandardsPyPage(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize, @Param("condition")String condition);
//    批量删除
    int deleteBatch(Integer[] keys);

    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}