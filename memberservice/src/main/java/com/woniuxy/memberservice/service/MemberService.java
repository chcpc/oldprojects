package com.woniuxy.memberservice.service;

import com.woniuxy.memberservice.pojo.Member;

public interface MemberService {
//  根据手机号查询
    public Member findMemberByMobile(String mobile);
}
