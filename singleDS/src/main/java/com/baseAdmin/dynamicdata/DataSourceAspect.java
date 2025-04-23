package com.baseAdmin.dynamicdata;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 *
 * @author btyuan
 * @version V1.0.0
 */

@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@within(com.baseAdmin.dynamicdata.CurDataSource)||@annotation(com.baseAdmin.dynamicdata.CurDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Class<?> target =  point.getTarget().getClass();
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        //CurDataSource ds = method.getAnnotation(CurDataSource.class);
        CurDataSource ds = getDataSourceKey(target,method);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
        } else {
            DynamicDataSource.setDataSource(ds.name());
        }

        try {
            return point.proceed();
        } finally {
            System.out.println("------------------");
           // DynamicDataSource.clearDataSource();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public CurDataSource getDataSourceKey(Class<?> target, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            Method m = target.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(CurDataSource.class)) {
                return (CurDataSource)m.getAnnotation(CurDataSource.class);
            }

            if (target.isAnnotationPresent(CurDataSource.class)) {
                return (CurDataSource)target.getAnnotation(CurDataSource.class);
            }
        } catch (Exception var5) {
            var5.printStackTrace();
           // logger.error(MessageFormat.format("通过注解切换数据源时发生异常[class={0},method={1}]：", target.getName(), method.getName()), var5);
        }

        return null;
    }
}

