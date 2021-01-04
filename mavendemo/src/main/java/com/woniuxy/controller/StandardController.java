package com.woniuxy.controller;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.github.pagehelper.PageInfo;
import com.woniuxy.pojo.Standard;
import com.woniuxy.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 */

@Controller
public class StandardController {
    @Autowired
    private StandardService standardService;
    @RequestMapping("/standard")
    public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1",required = false) Integer currentPage,
                             @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize) {
//        @RequestParam,即请求参数，value为参数名，defaultValue为默认值，required为false表示不是必须
        List<Standard> list = standardService.queryByPage(currentPage, pageSize);
        PageInfo<Standard> pageInfo = new PageInfo<>(list);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

}
