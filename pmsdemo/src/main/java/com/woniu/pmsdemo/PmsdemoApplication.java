package com.woniu.pmsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = {"com.woniu.pmsdemo.dao"})
@EnableCaching
@EnableScheduling
public class PmsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsdemoApplication.class, args);
    }

}
