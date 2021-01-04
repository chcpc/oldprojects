package com.woniuxy.mapper;

import com.woniuxy.pojo.Informations;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationsMapper {

    List<Informations> InformationQueryByPage(@Param("currentPage") Integer currentPage, @Param("pageSize")Integer pageSize);
//    添加查看次数
    void addviewCountByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Informations record);

    int insertSelective(Informations record);

    Informations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Informations record);

    int updateByPrimaryKey(Informations record);


    void addreplyCountByPrimaryKey(Integer infold);
}