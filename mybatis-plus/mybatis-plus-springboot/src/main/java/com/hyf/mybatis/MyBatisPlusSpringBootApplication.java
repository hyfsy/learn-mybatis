package com.hyf.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baB_hyf
 * @date 2022/01/22
 */
// MyBatis-Plus 必须要添加该注解
@MapperScan("com.hyf.mybatis.mapper")
@SpringBootApplication
public class MyBatisPlusSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusSpringBootApplication.class, args);
    }
}
