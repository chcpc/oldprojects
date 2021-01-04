package com.woniuxy.service;

import com.woniuxy.pojo.Standard;

import java.util.List;

public interface StandardService {
    List<Standard> queryByPage(Integer currentPage, Integer pageSize);
}
