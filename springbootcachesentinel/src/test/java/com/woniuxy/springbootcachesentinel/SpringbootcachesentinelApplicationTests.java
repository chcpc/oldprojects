package com.woniuxy.springbootcachesentinel;

import com.woniuxy.springbootcachesentinel.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcachesentinelApplicationTests {
    @Autowired
    private EmpService empService;
    @Test
    public void contextLoads() {
        empService.findEmp(1001);
    }

}
