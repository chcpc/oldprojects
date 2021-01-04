package com.woniuxy.courseservice.mapper;

import com.woniuxy.courseservice.pojo.Subscribe;
import org.apache.ibatis.annotations.Insert;

public interface SubscribeMapper {
    @Insert("insert into subscribe (sid,cid,mid,start_time,end_time) Values (null,#{cid},#{mid},#{startTime},#{endTime})")
    public int insertSubscribe(Subscribe subscribe);
}
