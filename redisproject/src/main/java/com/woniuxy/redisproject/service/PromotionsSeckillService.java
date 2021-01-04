package com.woniuxy.redisproject.service;

public interface PromotionsSeckillService {
    void process(Long psId, Integer userId);
    public String sendOrderToQueue(Integer userId);
}
