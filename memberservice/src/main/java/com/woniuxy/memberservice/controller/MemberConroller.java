package com.woniuxy.memberservice.controller;

import com.woniuxy.memberservice.pojo.Member;
import com.woniuxy.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberConroller {
    @Autowired
    MemberService memberService;

    @RequestMapping("/check")
    @ResponseBody
    public Map checkMember(String mobile){
        System.out.println("调用"+mobile);
        Map result = new HashMap<>();
        Member member = memberService.findMemberByMobile(mobile);
        if(member == null){
            result.put("message","会员信息不存在");
            result.put("code","500");
        }else{
            result.put("data",member);
            result.put("code","0");
            result.put("message","会员信息存在");
        }
        return result;
    }
}
