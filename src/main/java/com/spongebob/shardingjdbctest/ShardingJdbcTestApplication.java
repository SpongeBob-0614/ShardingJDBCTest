package com.spongebob.shardingjdbctest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.spongebob.shardingjdbctest.db.mappers")
@ComponentScan(basePackages = "com.spongebob")
public class ShardingJdbcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcTestApplication.class, args);
    }

}
