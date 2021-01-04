package com.woniuxy.redisproject.service;


import com.woniuxy.redisproject.pojo.Order;

public interface OrderService {
    Order findOrderByNo(String orderNO);
}
