package com.lyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.lyy.controller")
public class SpringBootApplicate {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicate.class, args);
    }
}
