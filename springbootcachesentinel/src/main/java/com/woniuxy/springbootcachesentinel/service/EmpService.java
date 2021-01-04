package com.woniuxy.springbootcachesentinel.service;

import com.woniuxy.springbootcachesentinel.pojo.Emp;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmpService {
    @Cacheable(value = "emp",key = "#id")
    public Emp findEmp(Integer id){
        Emp emp = new Emp();
        emp.setEmpno(id);
        emp.setEname("hello");
        emp.setHiredate(new Date());
        return emp;
    }
}
