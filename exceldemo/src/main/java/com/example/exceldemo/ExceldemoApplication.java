package com.example.exceldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.exceldemo.mapper")
public class ExceldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceldemoApplication.class, args);
    }

}
