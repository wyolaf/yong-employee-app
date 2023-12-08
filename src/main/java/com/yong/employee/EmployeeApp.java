package com.yong.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.yong.employee.mapper"})
public class EmployeeApp {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class, args);
    }
}
