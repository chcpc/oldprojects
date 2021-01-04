package com.woniuxy.service;

import com.woniuxy.pojo.Informations;

import java.util.List;

public interface InformationsService {
    List<Informations> queryByPage(Integer currentPage, Integer pageSize);

    Informations getInfoAndAddViewById(Integer id);
}
