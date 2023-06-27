package com.deepsoft.haolifa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.deepsoft.haolifa.dao.repository"})
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    public static void main(String[] args) {
//        //加载资源文件
//        ClassPathResource classPathResource = new ClassPathResource("static/msyh.ttf");
//        //获取路径
//        String path = classPathResource.getAbsolutePath();
//        System.out.println("path:" + path);
//
//    }

}
