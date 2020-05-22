package com.project.module.demo.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.project.module.demo.mapper"})
public class MyBatisConfig {
}
