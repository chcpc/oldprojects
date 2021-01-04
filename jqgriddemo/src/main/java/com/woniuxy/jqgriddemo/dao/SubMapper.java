package com.woniuxy.jqgriddemo.dao;

import com.woniuxy.jqgriddemo.po.Sub;

public interface SubMapper {
    int deleteByPrimaryKey(Integer subid);

    int insert(Sub record);

    int insertSelective(Sub record);

    Sub selectByPrimaryKey(Integer subid);

    int updateByPrimaryKeySelective(Sub record);

    int updateByPrimaryKey(Sub record);
}