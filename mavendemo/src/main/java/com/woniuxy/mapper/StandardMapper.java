package com.woniuxy.mapper;

import com.woniuxy.pojo.Standard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
//    @Select("select * from standard limit #{currentPage},#{pageSize}")
    List<Standard> queryByPage(@Param("currentPage") Integer currentPage, @Param("pageSize")Integer pageSize);
}