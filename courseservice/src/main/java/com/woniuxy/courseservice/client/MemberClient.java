package com.woniuxy.courseservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//与目标客户端名称对应
@FeignClient("member")
public interface MemberClient {
//  与目标方法的路径相对应，如果有参数需要使用@RequestParam注解
    @RequestMapping("/check")
    @ResponseBody
    public RestResult checkMember(@RequestParam("mobile") String mobile);
}
