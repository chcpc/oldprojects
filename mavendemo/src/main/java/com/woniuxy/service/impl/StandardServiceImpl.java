package com.woniuxy.service.impl;

import com.woniuxy.mapper.StandardMapper;
import com.woniuxy.pojo.Standard;
import com.woniuxy.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    StandardMapper standardMapper;
    @Override
    public List<Standard> queryByPage(Integer currentPage, Integer pageSize) {
        return standardMapper.queryByPage(currentPage,pageSize);
    }
}
