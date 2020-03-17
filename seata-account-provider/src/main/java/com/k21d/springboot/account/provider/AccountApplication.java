package com.k21d.springboot.account.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.k21d.springboot.account.provider")
@EnableDubbo(scanBasePackages = "com.k21d.springboot.account.provider")
@MapperScan("com.k21d.springboot.account.provider.mapper")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
