package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.ProductDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
    @Select("SELECT * FROM t_product_detail WHERE product_id=#{product_id}")
    List<ProductDetail> selectProductDetailByProductId(Integer id);
}