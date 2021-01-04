package com.woniu.pmsdemo.service.impl;

import com.woniu.pmsdemo.dao.OrderMapper;
import com.woniu.pmsdemo.pojo.Order;
import com.woniu.pmsdemo.service.OrderService;
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
