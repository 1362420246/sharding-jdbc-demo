package com.qbk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qbk.mapper")
public class ShardingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingDemoApplication.class, args);
	}

}
