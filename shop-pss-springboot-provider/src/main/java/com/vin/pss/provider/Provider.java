package com.vin.pss.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Author Vincent Chiu
 * @Date 2020-10-20 19:22
 */
//扫描Dubbo的service注解
@EnableDubbo
//扫描dao层
@MapperScan("com.vin.pss.provider.dao")
@SpringBootApplication
public class Provider {
    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
