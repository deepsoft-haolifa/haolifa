package com.deepsoft.haolifa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.deepsoft.haolifa.dao.repository","com.deepsoft.haolifa.dao.mapper"})
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
