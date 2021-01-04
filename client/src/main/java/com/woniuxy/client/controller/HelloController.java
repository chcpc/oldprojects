package com.woniuxy.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/10/8
 */
@Controller
public class HelloController {


    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello spring cloud "+port;
    }
}
