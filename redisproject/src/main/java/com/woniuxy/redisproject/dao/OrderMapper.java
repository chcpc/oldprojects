package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    @Select("select * from t_order where order_sn = #{orderNO}")
    Order selectByOrderNO(String orderNO);
}