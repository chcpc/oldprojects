package com.woniuxy.service.impl;

import com.woniuxy.mapper.InformationsMapper;
import com.woniuxy.pojo.Informations;
import com.woniuxy.service.InformationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InformationsServiceImpl implements InformationsService {
    @Autowired
    InformationsMapper informationsMapper;
    @Override
    public List<Informations> queryByPage(Integer currentPage, Integer pageSize) {
        return informationsMapper.InformationQueryByPage(currentPage,pageSize);
    }
//    @Transactional
    @Override
    public Informations getInfoAndAddViewById(Integer id) {
        //  同时执行添加查看次数和查询信息结果
        informationsMapper.addviewCountByPrimaryKey(id);
        return informationsMapper.selectByPrimaryKey(id);
    }
}
