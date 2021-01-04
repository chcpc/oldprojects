package com.woniu.pmsdemo.service;

import com.woniu.pmsdemo.pojo.Order;

public interface OrderService {
    Order findOrderByNo(String orderNO);
}
