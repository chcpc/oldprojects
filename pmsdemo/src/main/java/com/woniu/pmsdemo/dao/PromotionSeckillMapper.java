package com.woniu.pmsdemo.dao;

import com.woniu.pmsdemo.pojo.PromotionSeckill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PromotionSeckillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionSeckill record);

    int insertSelective(PromotionSeckill record);

    PromotionSeckill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionSeckill record);

    int updateByPrimaryKey(PromotionSeckill record);

    @Select("select * from t_promotion_seckill where now() between start_time and end_time and status =0")
    List<PromotionSeckill> queryPromotionSeckill();
}