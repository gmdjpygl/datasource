package com.baseAdmin.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.*;
 
//@EnableWebMvc
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
 
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        		.enable(true)   // 开关
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))// 扫描所有指定包
                // .apis(RequestHandlerSelectors.basePackage("com.baseAdmin.master.t1.controller"))// 扫描所有指定包
                .paths(PathSelectors.any())// 任何请求都扫描
                .build();
               // .securitySchemes(Collections.singletonList(apiKey()))
               // .securityContexts(Collections.singletonList(securityContext()));
    }
 
    private static ApiKey apiKey() {
        return new ApiKey("token", "token", "header");
    }
 
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("token", new AuthorizationScope[0])))
                .build();
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //.description("API管理平台")
                .title("API管理平台")
                .build();
    }
}
