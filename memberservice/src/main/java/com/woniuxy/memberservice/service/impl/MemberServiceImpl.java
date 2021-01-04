package com.woniuxy.memberservice.service.impl;

import com.woniuxy.memberservice.mapper.MemberMapper;
import com.woniuxy.memberservice.pojo.Member;
import com.woniuxy.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public Member findMemberByMobile(String mobile) {
        return memberMapper.queryMemberByMobile(mobile);
    }
}
