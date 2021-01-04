package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.ProductParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductParam record);

    int insertSelective(ProductParam record);

    ProductParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductParam record);

    int updateByPrimaryKey(ProductParam record);
    @Select("SELECT * FROM t_product_param WHERE product_id=#{product_id}")
    List<ProductParam> selectProductParamByProductId(Integer id);
}