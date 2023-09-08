package com.zhuangpo.event;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *  启动类
 * 
 * @author xub
 * @since 2023/9/5 上午11:31
 */
@EnableAsync 
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

	}
}
