package com.woniuxy.redisproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
//启用任务调度
@EnableScheduling
//启用缓存
@EnableCaching
@MapperScan(value = {"com.woniuxy.redisproject.dao"})
@SpringBootApplication
public class RedisprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisprojectApplication.class, args);
    }

}
