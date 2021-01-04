package com.woniuxy.courseservice.service.impl;

import com.woniuxy.courseservice.client.MemberClient;
import com.woniuxy.courseservice.client.RestResult;
import com.woniuxy.courseservice.exception.SubscribeException;
import com.woniuxy.courseservice.mapper.CourseMapper;
import com.woniuxy.courseservice.mapper.SubscribeMapper;
import com.woniuxy.courseservice.pojo.Course;
import com.woniuxy.courseservice.pojo.Subscribe;
import com.woniuxy.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private MemberClient memberClient;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Override
    public List<Course> findCourses() {
        System.out.println("查询:"+courseMapper.queryCourses());
        return courseMapper.queryCourses();
    }

    @Override
    public void sub(Integer cid, String mobile, Date start, Date end) {
//      订阅课程
//      1.验证手机号是否存在（需要调用会员服务），不存在则抛订阅异常
       RestResult restResult = memberClient.checkMember(mobile);
       System.out.println(mobile);
       if(restResult.getData()==null){
            throw new SubscribeException("该会员不存在");
        }
//      2.查询课程存量，不存在、不足都要抛订阅异常
        Course course = courseMapper.queryCoursesById(cid);
       if(course==null){
           throw new SubscribeException("该课程不存在");
       }
       if(course.getStock()<=0){
           throw new SubscribeException("该课程目前预约名额已满");
       }
//      3.以上没问题则更新课程数量和订阅表
//      添加预约信息
        Subscribe subscribe = new Subscribe();
        subscribe.setCid(cid);
        subscribe.setMid(restResult.getData().getId());
        subscribe.setStartTime(start);
        subscribe.setEndTime(end);
        subscribeMapper.insertSubscribe(subscribe);
//      更新课程数量
        courseMapper.updateCourseStock(cid);
    }
}
