package com.AopDemo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 文件名：AopDemo
 * 创建者：
 * 创建时间：2024-08-20
 * 描述：
 */
public class AopDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        // 获取MathService的Bean
        MathService mathService = context.getBean("mathService", MathService.class);
        mathService.add(12, 13);
    }
}