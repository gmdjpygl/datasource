package com.baseAdmin.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 文件名：LoggingAspect
 * 创建者：宁贝贝
 * 创建时间：2024-08-20
 * 描述：
 */
@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * @Pointcut注解定义了一个切点，用于匹配com.example.service包下所有类的所有方法
     */
    @Pointcut("execution(* com.baseAdmin.dempAop.service.MathService.add(..))")
    public void logOnMathServiceAdd() {}
    /**
     * @Before 注解的关键属性：
     *     value 或 pointcut：指定切点表达式，用于匹配哪些方法的执行将触发通知。如果不指定 value，则通知将应用于所有方法。
     *     joinPoint：方法参数，表示当前的连接点（例如，被通知的方法），可以用于获取方法签名、参数等信息。
     *     其他可选参数包括 argNames（指定方法参数的名称以匹配特定的参数值）等。
     * @param joinPoint
     */
    @Before("logOnMathServiceAdd()")
    public void logBeforeAddition(JoinPoint joinPoint) {
        logger.info("前置方法 {},{}", joinPoint.getArgs()[0],joinPoint.getArgs()[1]);
    }
    /**
     * @AfterReturning注解的关键属性：
     *     value 或 pointcut：指定切点表达式，用于匹配哪些方法的执行将触发通知。如果不指定value，则通知将应用于所有方法。
     *     returning：用于指定方法返回值的参数名称。在通知方法中，可以使用此参数名称来引用方法的返回值。
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "logOnMathServiceAdd()", returning = "result")
    public void logAfterAdditionReturning(JoinPoint joinPoint, Object result) {
        logger.info("后置方法{},{},{}", joinPoint.getArgs()[0], joinPoint.getArgs()[1], result);
    }
}