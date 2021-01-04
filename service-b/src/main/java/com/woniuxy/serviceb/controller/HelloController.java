package com.woniuxy.serviceb.controller;

import com.woniuxy.serviceb.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
//  反馈信息，由service-a来调用
    @RequestMapping("/hello")
    @ResponseBody
    public Map hello(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success");
        return map;
    }
//  使用通讯组件feign，其方法中带有参数时
    @RequestMapping("/emp")
    @ResponseBody
    public Map findEmp(Integer empno){
        Map map = new HashMap();
        Emp emp = new Emp();
        emp.setEmpno(empno);
        emp.setEname("hello");
        emp.setHiredate(new Date());
        map.put("data",emp);
        map.put("msg","success");
        map.put("code","200");
        return map;
    }
}
