package com.woniuxy.jqgriddemo.service;

import com.woniuxy.jqgriddemo.po.JqGridResquest;
import com.woniuxy.jqgriddemo.po.JqGridResult;

public interface BaseService {
    JqGridResult queryByConditionAutoPage(JqGridResquest jqGridResquest);
}
