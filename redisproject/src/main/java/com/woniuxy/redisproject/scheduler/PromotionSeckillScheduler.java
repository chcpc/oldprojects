package com.woniuxy.redisproject.scheduler;



import com.woniuxy.redisproject.dao.ProductMapper;
import com.woniuxy.redisproject.dao.PromotionSeckillMapper;
import com.woniuxy.redisproject.pojo.Product;
import com.woniuxy.redisproject.pojo.PromotionSeckill;
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

//  将所有处于待秒杀的项目取出，获取其product_id并使用循环找出对应的prodcut
//  并把所有待活动id和商品对象放入到map中，标记为活动状态，并将map放入到redis当中
//    @Scheduled(cron = "0/5 * * * * ?")
    public void initPromotionSeckill(){
        List<PromotionSeckill> promotionSeckills =  promotionSeckillMapper.selectPromotionSeckill();
        Map map = new HashMap();
//      将查询到的Product实例对象和秒杀活动Id对应起来，放入到Map中，并标记为正在活动状态
        for(PromotionSeckill p : promotionSeckills){
            Product product = productMapper.selectByPrimaryKey(p.getProductId());
            map.put(p.getId().toString(),product);
//          标记为正在活动状态
            p.setStatus(1);
//          返回数据到数据库当中
            promotionSeckillMapper.updateByPrimaryKeySelective(p);
//          同时将每个活动商品对应数量加载到缓存中
            for (int i=0;i<p.getPsCount();i++){
                redisTemplate.opsForList().leftPush("seckill:count:"+p.getId(),p.getProductId().toString());
//              设置过期时间
                redisTemplate.expire("seckill:count:"+p.getId(),2L,TimeUnit.HOURS);
            }
        }
//      将map放入到redis缓存当中
        redisTemplate.opsForHash().putAll("seckillproducts",map);
//      设置键的过期时间
        redisTemplate.expire("seckillproducts",2L,TimeUnit.HOURS);
    }

}
