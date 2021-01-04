package com.woniuxy.redisproject.dao;

import com.woniuxy.redisproject.pojo.PromotionSeckill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PromotionSeckillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PromotionSeckill record);

    int insertSelective(PromotionSeckill record);

    PromotionSeckill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionSeckill record);

    int updateByPrimaryKey(PromotionSeckill record);
//  这是给任务调度使用的查询
//  获取当前时间在表中的开始和结束时间之内且处于待开始状态的所有活动项目
    @Select("SELECT * FROM t_promotion_seckill WHERE now() BETWEEN start_time AND end_time AND status = 0")
    List<PromotionSeckill> selectPromotionSeckill();
}