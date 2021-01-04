package com.woniuxy.jqgriddemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.jqgriddemo.dao.SubMapper;
import com.woniuxy.jqgriddemo.po.JqGridResult;
import com.woniuxy.jqgriddemo.po.Sub;
import com.woniuxy.jqgriddemo.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubServiceImpl implements SubService {
    @Autowired
    SubMapper subMapper;
    @Override
    public JqGridResult seleteByPrimaryKey(Integer page, Integer pageSize,Integer id) {
        System.out.println("执行");
        PageHelper.startPage(page, pageSize);
        List<Sub> result = new ArrayList<>();
        result.add(subMapper.selectByPrimaryKey(id));
        PageInfo<Sub> pageList = new PageInfo<Sub>(result);
        //      新建一个封装类对象，设置参数，传入查询数据
        JqGridResult<Sub> grid = new JqGridResult<>();
        grid.setTotal(pageList.getPages());
        grid.setRows(result);
        grid.setPage(pageList.getPageNum());
        grid.setRecords(pageList.getTotal());
        return grid;
    }

}
