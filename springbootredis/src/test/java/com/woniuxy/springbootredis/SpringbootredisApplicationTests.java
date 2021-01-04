package com.woniuxy.springbootredis;

import com.woniuxy.springbootredis.pojo.Emp;
import com.woniuxy.springbootredis.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootredisApplicationTests {
    @Autowired
    private EmpService empService;

    @Test
    public void contextLoads() {
        Emp e = empService.findByEmpno(1005);
        System.out.println(e.getEname());
    }

    @Test
    public void testEmpList(){
        List<Emp> list = empService.findEmps();
        for (Emp emp : list) {
            System.out.println(emp.getEname());
        }
    }


    @Test
    public void testSave(){
        Emp e= new Emp(1,"李四",new Date());
        empService.saveEmp(e);
    }

    @Test
    public void testUpdate(){
        Emp e= new Emp(1,"李四",new Date());
        empService.updateEmp(e);
    }

    @Test
    public void testDelete(){

        empService.deleteEmp(1);
    }

}
