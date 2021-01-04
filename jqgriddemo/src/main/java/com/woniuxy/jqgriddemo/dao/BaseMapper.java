package com.woniuxy.jqgriddemo.dao;

import com.woniuxy.jqgriddemo.po.Base;
import com.woniuxy.jqgriddemo.po.JqGridResquest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BaseMapper {
    //PageHelper分页方法
//    List<Base> selectByCondition(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize, @Param("jr")JqGridResquest jqGridResquest);
    List<Base> selectByCondition(@Param("condition")JqGridResquest jqGridResquest);
    List<Base> selectAll(@Param("str1")String str1,@Param("str2")String str2);
    int deleteByPrimaryKey(Integer id);

    int insert(Base record);

    int insertSelective(Base record);

    Base selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Base record);

    int updateByPrimaryKey(Base record);
}