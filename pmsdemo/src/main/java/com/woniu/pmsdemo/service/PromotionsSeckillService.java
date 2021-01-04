package com.woniu.pmsdemo.service;

public interface PromotionsSeckillService {
    void process(Long psId, Integer userId);

    /**
     * 将订单数据投递到MQ
     * @param userId 用户Id
     * @return 订单编号
     */
    public String sendOrderToQueue(Integer userId);
}
