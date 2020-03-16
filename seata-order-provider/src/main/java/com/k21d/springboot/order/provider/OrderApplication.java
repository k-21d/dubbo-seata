package com.k21d.springboot.order.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.k21d.springboot.order.provider")
@EnableDubbo(scanBasePackages = "com.k21d.springboot.order.provider")
@MapperScan("com.k21d.springboot.order.provider.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
