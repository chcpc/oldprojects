package com.woniuxy.memberservice.mapper;

import com.woniuxy.memberservice.pojo.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select("select * from member where mobile = #{mobile}")
    public Member queryMemberByMobile(String mobile);
}
