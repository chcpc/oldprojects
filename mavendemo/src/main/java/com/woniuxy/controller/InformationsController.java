package com.woniuxy.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.pojo.Informations;
import com.woniuxy.pojo.Replies;
import com.woniuxy.service.InformationsService;
import com.woniuxy.service.RepliesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 */
@Slf4j
@Controller
public class InformationsController {
    @Autowired
    private InformationsService informationsService;
    @Autowired
    private RepliesService repliesService;

    @RequestMapping("/navi")
    public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1",required = false) Integer currentPage,
                             @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize) {
//        @RequestParam,即请求参数，value为参数名，defaultValue为默认值，required为false表示不是必须
        List<Informations> list = informationsService.queryByPage(currentPage,pageSize);
        PageInfo<Informations> pageInfo = new PageInfo<>(list);
        ModelAndView mv = new ModelAndView("navi");
        mv.addObject("pageInfo",pageInfo);
        log.debug("list execute");
        return mv;
    }
    @RequestMapping("/details")
    public ModelAndView details(@RequestParam(value = "id") Integer id) {
        //  查询信息并添加查看次数
        Informations info = informationsService.getInfoAndAddViewById(id);
        Integer infold = id;
        List<Replies> list = repliesService.getRepliesByInfold(infold);
        ModelAndView mv = new ModelAndView("details");
        mv.addObject("info",info);
        System.out.println(list);
        mv.addObject("lists",list);
        return mv;
    }
}
