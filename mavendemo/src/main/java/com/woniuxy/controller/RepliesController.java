package com.woniuxy.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.pojo.Informations;
import com.woniuxy.pojo.Replies;
import com.woniuxy.service.InformationsService;
import com.woniuxy.service.RepliesService;
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
public class RepliesController {
    @Autowired
    private InformationsService informationsService;
    @Autowired
    private RepliesService repliesService;

    @RequestMapping("/replies")
    public ModelAndView replies(Replies replies) {
        System.out.println("进入");
        System.out.println(replies);
        //  新增信息道replies表并修改informations表的回复次数
        int id = replies.getInfold();

        repliesService.addReplyAndAddreplyCount(replies);
        ModelAndView mv = new ModelAndView("redirect:/details?id="+id);
        return mv;
    }
}
