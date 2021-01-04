package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.ProductCover;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductCoverMapper {
    @Select("select * FROM t_product_cover WHERE product_id=#{product_id};")
    List<ProductCover> selectProductCoverByProductId(Integer product_id);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductCover record);

    int insertSelective(ProductCover record);

    ProductCover selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCover record);

    int updateByPrimaryKey(ProductCover record);
}