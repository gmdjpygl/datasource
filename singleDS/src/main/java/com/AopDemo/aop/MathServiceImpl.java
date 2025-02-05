package com.AopDemo.aop;

/**
 * 文件名：MathServiceImpl
 * 创建者：
 * 创建时间：2024-08-20
 * 描述：
 */
public class MathServiceImpl implements MathService {
    @Override
    public int add(int a, int b) {
        int sum = a+b;
        System.out.println("执行计算方法  "+ sum);
        return sum;
    }
}