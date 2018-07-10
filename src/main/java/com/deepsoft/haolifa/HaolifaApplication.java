package com.deepsoft.haolifa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan({"com.deepsoft.haolifa.dao.repository"})
public class HaolifaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaolifaApplication.class, args);
	}
}
