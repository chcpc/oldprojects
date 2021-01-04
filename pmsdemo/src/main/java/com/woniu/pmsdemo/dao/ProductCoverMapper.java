package com.woniu.pmsdemo.dao;

import com.woniu.pmsdemo.pojo.ProductCover;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductCoverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCover record);

    int insertSelective(ProductCover record);

    ProductCover selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCover record);

    int updateByPrimaryKey(ProductCover record);

    @Select("select * from t_product_cover where product_id = #{id}")
    List<ProductCover> queryCoversByProductId(Integer id);
}