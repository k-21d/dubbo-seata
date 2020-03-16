package com.k21d.springboot.storage.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.k21d.springboot.storage.provider")
@EnableDubbo(scanBasePackages = "com.k21d.springboot.storage.provider")
@MapperScan("com.k21d.springboot.storage.provider.mapper")
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class,args);
    }
}
