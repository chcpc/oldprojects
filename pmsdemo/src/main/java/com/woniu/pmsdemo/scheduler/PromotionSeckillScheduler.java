package com.woniu.pmsdemo.scheduler;

import com.woniu.pmsdemo.dao.ProductMapper;
import com.woniu.pmsdemo.dao.PromotionSeckillMapper;
import com.woniu.pmsdemo.pojo.Product;
import com.woniu.pmsdemo.pojo.PromotionSeckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/26
 */
@Component
public class PromotionSeckillScheduler {

    @Autowired
    private PromotionSeckillMapper promotionSeckillMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    public void initPromotionSeckill(){
        List<PromotionSeckill> list = promotionSeckillMapper.queryPromotionSeckill();
        if(list.size()>0){}
        Map map = new HashMap<>();
        for (PromotionSeckill p : list) {
            Product product = productMapper.selectByPrimaryKey(p.getProductId());
            map.put(p.getId().toString(),product);
            p.setStatus(1);
            promotionSeckillMapper.updateByPrimaryKeySelective(p);
            for (int i = 0; i < p.getPsCount(); i++) {
                redisTemplate.opsForList().rightPush("seckill:count:"+p.getId(),p.getProductId().toString());
                redisTemplate.expire("seckill:count:"+p.getId(),2L,TimeUnit.HOURS);
            }
        }
        redisTemplate.opsForHash().putAll("seckillproducts",map);
        //设置键的过期时间
        redisTemplate.expire("seckillproducts",2L, TimeUnit.HOURS);
    }





}
