package com.jincou.mybatisplus;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.jincou.mybatisplus.dao")
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		SpringApplication.run(MainApplication.class, args);

	}
}
