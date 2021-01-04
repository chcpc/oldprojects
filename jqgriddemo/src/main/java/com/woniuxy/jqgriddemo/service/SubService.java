package com.woniuxy.jqgriddemo.service;

import com.woniuxy.jqgriddemo.po.JqGridResult;

public interface SubService {
    JqGridResult seleteByPrimaryKey(Integer page, Integer pageSize, Integer subid);
}
