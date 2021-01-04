package com.woniuxy.jqgriddemo.controller;

import com.woniuxy.jqgriddemo.po.Base;
import com.woniuxy.jqgriddemo.po.JqGridResquest;
import com.woniuxy.jqgriddemo.po.JqGridResult;
import com.woniuxy.jqgriddemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {
    @Autowired
    BaseService baseService;

    @RequestMapping(value = "/index",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JqGridResult index(JqGridResquest jqGridResquest){
        if(jqGridResquest != null){
            if(jqGridResquest.getWhereName() != null && jqGridResquest.getWhereName() != ""){
                System.out.println(jqGridResquest.getWhereName());
                System.out.println(jqGridResquest);
                if(jqGridResquest.getWhereValue()!=null){
                    System.out.println(jqGridResquest.getWhereValue().get(0));
                }
            }
        }


//      方法参数是封装类，封装了jqgrid传来的属性
//      传入封装类，按条件查询
        JqGridResult<Base> jqgridResult = baseService.queryByConditionAutoPage(jqGridResquest);
        System.out.println(jqgridResult);
        return jqgridResult;
    }



}
