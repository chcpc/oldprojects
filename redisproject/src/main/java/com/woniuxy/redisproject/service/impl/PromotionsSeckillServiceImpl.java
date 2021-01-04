package com.woniuxy.redisproject.service.impl;


import com.woniuxy.redisproject.dao.PromotionSeckillMapper;
import com.woniuxy.redisproject.exception.SeckillException;
import com.woniuxy.redisproject.pojo.PromotionSeckill;
import com.woniuxy.redisproject.service.PromotionsSeckillService;
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
    private PromotionSeckillMapper promotionSeckillMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

//  将秒杀ID和用户ID结合起来
    @Override
    public void process(Long psId, Integer userId) {
//      查询秒杀表，查看活动状态
        PromotionSeckill promotionSeckill = promotionSeckillMapper.selectByPrimaryKey(psId);
        if(promotionSeckill == null){
            throw new SeckillException("秒杀活动不存在");
        }
        if(promotionSeckill.getStatus() == 0){
            throw new SeckillException("活动没有开始");
        }
        if(promotionSeckill.getStatus() == 2){
            throw new SeckillException("秒杀活动已经结束");
        }
//      查询缓存，查看用户是否已经参与秒杀
        boolean isMember = redisTemplate.opsForSet().isMember("seckill:user:"+psId,userId);
//      如果未参与秒杀
        if(!isMember){
            //  redis是单线程,所以不会存在线程安全问题
//          将秒杀商品从对应的redis缓存项中弹出并取出值，该值为productId
            Object productId = redisTemplate.opsForList().leftPop("seckill:count:"+psId);
//          判断商品是否还有剩余,如果弹出为null则表示没有了
            if(productId!=null){
                //  将用户存储到redis当中seckill:count:+抢购id
                redisTemplate.opsForSet().add("seckill:user:"+psId,userId);
            }else{
                throw new RuntimeException("该商品以售罄");
            }
        }else{
            throw new RuntimeException("不能重复抢购");
        }
    }
    @Override
    public String sendOrderToQueue(Integer userId) {
//      使用HashMap装信息
        Map data = new HashMap<>();
//      先放入userId
        data.put("userId",userId);
//      再生成订单编号(UUID)，放入其中
        String orderNo = UUID.randomUUID().toString();
        System.out.println("orderNo:"+orderNo);
        data.put("orderNo",orderNo);
//      使用rabbitTemplate将装它们的data放入到消息队列中
        rabbitTemplate.convertAndSend("order_exchange",null,data);
//      最后将orderNo返回
        return orderNo;
    }
}
