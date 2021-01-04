package com.woniu.pmsdemo.dao;

import com.woniu.pmsdemo.pojo.ProductParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductParam record);

    int insertSelective(ProductParam record);

    ProductParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductParam record);

    int updateByPrimaryKey(ProductParam record);

    @Select("select * from t_product_param where product_id = #{id}")
    List<ProductParam> queryByProductId(Integer id);
}