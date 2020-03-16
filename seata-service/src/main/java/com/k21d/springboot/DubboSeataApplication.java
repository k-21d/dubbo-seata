package com.k21d.springboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboSeataApplication.class,args);
    }
}
