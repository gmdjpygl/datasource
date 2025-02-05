package com.AopDemo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 文件名：AopConfig
 * 创建者：
 * 创建时间：2024-08-20
 * 描述： EnableAspectJAutoProxy 开启aop
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.demo.aop")
public class AopConfig {
    @Bean(value = "mathService") //这个注解主要是设置容器中对象的名称，（如果不设置默认的是首字母小写类名称）
    public MathService BusServiceImpl() {
        return new MathServiceImpl();
    }
}