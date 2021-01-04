package com.woniu.pmsdemo.dao;

import com.woniu.pmsdemo.pojo.ProductDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

    @Select("select * from t_product_detail where product_id = #{id}")
    List<ProductDetail> queryByProductId(Integer id);
}