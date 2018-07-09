package com.deepsoft.haolifa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: Swagger2 config
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("title：好利阀信息管理系统_接口文档")
                        .description("description：用于好利阀信息管理系统的各个XXX模块...")
                        .contact(new Contact("paul", null, null))
                        .version("version:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.deepsoft.haolifa.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
