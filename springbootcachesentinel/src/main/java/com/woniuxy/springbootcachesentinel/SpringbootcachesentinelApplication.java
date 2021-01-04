package com.woniuxy.springbootcachesentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//启用缓存
@EnableCaching
@SpringBootApplication
public class SpringbootcachesentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcachesentinelApplication.class, args);
    }

}
