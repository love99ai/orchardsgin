package com.orchardsign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.orchardsign.dao")
public class OrchardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchardsApplication.class, args);
	}
}
