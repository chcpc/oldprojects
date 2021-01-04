package com.woniuxy.jqgriddemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.jqgriddemo.dao.BaseMapper;
import com.woniuxy.jqgriddemo.po.Base;
import com.woniuxy.jqgriddemo.po.JqGridResquest;
import com.woniuxy.jqgriddemo.po.JqGridResult;
import com.woniuxy.jqgriddemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseMapper baseMapper;
    @Override
    public JqGridResult queryByConditionAutoPage(JqGridResquest jqGridResquest) {

//      注：可以使用PageHelper的静态方法设置 当前页 和 页大小 ，以及 排序字段 和 排序方式 ，无需将参数传入到dao层
//      排序sql拼接，从JqGridResquest中获取排序字段Sidx和排序方式sord，并判断是否不为空
        String orderBy = "";
        if(jqGridResquest.getSidx() != null && jqGridResquest.getSidx()!= ""){
            orderBy =jqGridResquest.getSidx()+" "+jqGridResquest.getSord();
        }
//      将几个参数装入其中
        PageHelper.startPage(jqGridResquest.getPage(), jqGridResquest.getRows(), orderBy);
//      注意，以上参数都是从前台获取的，jqgrid可以通过点击列标题实现顺序（数字、日期）
//      此外，可以有默认排序方式，需要在jqgrid设置
//      条件查询
        List<Base> result = baseMapper.selectByCondition(jqGridResquest);

        PageInfo<Base> pageList = new PageInfo<>(result);
//      新建一个封装类对象，设置参数，传入查询得到的数据
        JqGridResult<Base> grid = new JqGridResult<>();
//      总页数
        grid.setTotal(pageList.getPages());
//      存入查询数据
        grid.setRows(result);
//      当前页
        grid.setPage(pageList.getPageNum());
//      总条数
        grid.setRecords(pageList.getTotal());

        return grid;
    }
}
