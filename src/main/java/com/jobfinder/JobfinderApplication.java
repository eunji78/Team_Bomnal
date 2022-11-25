package com.jobfinder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jobfinder")
public class JobfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobfinderApplication.class, args);
	}

}
