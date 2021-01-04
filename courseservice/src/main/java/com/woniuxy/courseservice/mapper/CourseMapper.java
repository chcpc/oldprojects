package com.woniuxy.courseservice.mapper;

import com.woniuxy.courseservice.pojo.Course;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
//  查询课程列表
    @Select("select * from course")
    public List<Course> queryCourses();
//  根据课程id查询课程信息
    @Select("select * from course where cid=#{cid}")
    Course queryCoursesById(Integer cid);
//  更新课程数量
    @Update("update course set stock=stock-1 where cid = #{cid}")
    int updateCourseStock(Integer cid);
}
