package com.woniuxy.jqgriddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//mapper扫描
@MapperScan(value = {"com.woniuxy.jqgriddemo.dao"})
@SpringBootApplication
public class JqgriddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JqgriddemoApplication.class, args);
    }

}
