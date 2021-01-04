package com.woniuxy.courseservice.service;

import com.woniuxy.courseservice.pojo.Course;

import java.util.Date;
import java.util.List;


public interface CourseService {
//  查询课程
    public List<Course> findCourses();
    //  订阅课程
    void sub(Integer cid, String mobile, Date start, Date end);
}
