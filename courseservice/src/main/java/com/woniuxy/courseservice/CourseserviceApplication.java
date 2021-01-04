package com.woniuxy.courseservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //  启用feign客户端
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.woniuxy.courseservice.mapper")
public class CourseserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseserviceApplication.class, args);
    }

}
