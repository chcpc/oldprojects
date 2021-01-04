package com.woniuxy.courseservice.controller;

import com.woniuxy.courseservice.pojo.Course;
import com.woniuxy.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")//  该类下的所有方法都可与跨域访问
@CrossOrigin//  该类下的所有方法都可与跨域访问
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Course> courses(){
//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
//        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        return courseService.findCourses();
    }
    @RequestMapping("/sub")
    @ResponseBody
    public Map sub(Integer cid, String mobile, Date start, Date end){
        Map result = new HashMap();
        try {
            courseService.sub(cid,mobile,start,end);
            result.put("code","0");
            result.put("message","预约成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","500");
            result.put("message","课程预约失败");
        }
        return result;
    }
}
