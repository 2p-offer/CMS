package com.wy.manager.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: wangyan
 * @Date: 2019/2/10
 */
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.wy.manager.mp.*.dao")
@SpringBootApplication
@EnableCaching
public class ManagerBmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerBmpApplication.class, args);
        System.out.println("URCS MANAGER-MP BOOT SUCCESS");
    }
}
