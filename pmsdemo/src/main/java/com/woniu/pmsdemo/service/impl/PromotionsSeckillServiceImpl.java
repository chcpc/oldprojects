package com.woniu.pmsdemo.service.impl;

import com.woniu.pmsdemo.dao.PromotionSeckillMapper;
import com.woniu.pmsdemo.exception.SeckillException;
import com.woniu.pmsdemo.pojo.PromotionSeckill;
import com.woniu.pmsdemo.service.PromotionsSeckillService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/26
 */

@Service
public class PromotionsSeckillServiceImpl implements PromotionsSeckillService {

    @Autowired
    private PromotionSeckillMapper seckillMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void process(Long psId, Integer userId) {

        PromotionSeckill promotionSeckill = seckillMapper.selectByPrimaryKey(psId);
        if(promotionSeckill == null){
            throw new SeckillException("秒杀活动不存在");
        }
        if(promotionSeckill.getStatus() == 0){
            throw new SeckillException("活动没有开始");
        }
        if(promotionSeckill.getStatus() == 2){
            throw new SeckillException("秒杀活动已经结束");
        }

        //当前用户不能重复抢购，提示： 将抢购过商品的用户存储在redis
        boolean isMember = redisTemplate.opsForSet().isMember("seckill:user:"+psId,userId);
        if(!isMember){
            //商品不能超卖
            Object productId =  redisTemplate.opsForList().leftPop("seckill:count:"+psId);
            if(productId != null){
                redisTemplate.opsForSet().add("seckill:user:"+psId,userId);
            }else{
                throw new RuntimeException("该商品已经售罄");
            }
        }else{
            throw new RuntimeException("不能重复抢购");
        }
    }

    @Override
    public String sendOrderToQueue(Integer userId) {
        Map data = new HashMap<>();
        data.put("userId",userId);
        String orderNo = UUID.randomUUID().toString();
        System.out.println("orderId:"+orderNo);
        data.put("orderNo",orderNo);
        rabbitTemplate.convertAndSend("order_exchange",null,data);
        return orderNo;
    }
}
