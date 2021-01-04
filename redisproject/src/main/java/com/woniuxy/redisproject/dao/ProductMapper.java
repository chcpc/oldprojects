package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    @Select("select * from t_product where last_update_time > now() - interval 10 MINUTE")
    List<Product> selectProductByLastUpdate();
}