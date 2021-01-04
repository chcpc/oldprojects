package com.woniuxy.jqgriddemo.controller;

import com.woniuxy.jqgriddemo.po.JqGridResquest;
import com.woniuxy.jqgriddemo.po.JqGridResult;
import com.woniuxy.jqgriddemo.po.Sub;
import com.woniuxy.jqgriddemo.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubController {
    @Autowired
    SubService subService;
    @RequestMapping("/sub")
    @ResponseBody
    public JqGridResult sub(JqGridResquest jqGridResquest){
        int page = jqGridResquest.getPage();
        int rows = jqGridResquest.getRows();
        int subid = jqGridResquest.getId();
        //其实参数可以直接获取到，只要和jqgrid里定义的名称一致就可以
        System.out.println("page:"+page);
        System.out.println("rows:"+rows);
        System.out.println("subid:"+subid);

        if (jqGridResquest == null) {
            page = 1;
        }
        int pageSize = 20;
        if(jqGridResquest != null){
            pageSize = rows;
        }
        JqGridResult<Sub> jqgridResult = subService.seleteByPrimaryKey(page, pageSize,subid);
        System.out.println(jqgridResult);
        return jqgridResult;
    }
}
