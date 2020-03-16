package com.k21d.springboot.bussiness.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.k21d.springboot.bussiness.provider")
@EnableDubbo(scanBasePackages = "com.k21d.springboot.bussiness.provider")
public class BussinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BussinessApplication.class,args);
    }
}
