package com.woniuxy.memberservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient//   启用客户端
@SpringBootApplication
@MapperScan("com.woniuxy.memberservice.mapper")
public class MemberserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberserviceApplication.class, args);
    }

}
