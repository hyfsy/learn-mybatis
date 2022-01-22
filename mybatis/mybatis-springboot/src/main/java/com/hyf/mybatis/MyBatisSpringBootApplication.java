package com.hyf.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baB_hyf
 * @date 2022/01/22
 */
// 默认扫描 @Mapper 注解
// @MapperScan("com.hyf.mybatis.mapper")
@SpringBootApplication
public class MyBatisSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisSpringBootApplication.class, args);
    }
}
