package com.woniuxy.springbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//注解开启Redis缓存
@EnableCaching
@SpringBootApplication
public class SpringbootredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootredisApplication.class, args);
    }

}
