package com.woniuxy.redisproject.service.impl;


import com.woniuxy.redisproject.dao.OrderMapper;
import com.woniuxy.redisproject.pojo.Order;
import com.woniuxy.redisproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/10/8
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order findOrderByNo(String orderNO) {
        return orderMapper.selectByOrderNO(orderNO);
    }
}
