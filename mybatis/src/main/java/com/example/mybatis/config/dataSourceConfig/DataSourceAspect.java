package com.example.mybatis.config.dataSourceConfig;

import com.example.mybatis.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Author: YinJiaqi
 * Date: 11/11/2020 3:28 PM
 * Content:
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.example.mybatis.annotation.DataSource)")
    public void dataSourcePointCut(){

    }

    @Around(value = "dataSourcePointCut()")
   public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if(annotation == null){
            DynamicDataSource.setDataSource("one");
        }else{
             DynamicDataSource.setDataSource(annotation.name());
        }
        try {
            return point.proceed();
        }finally {
            DynamicDataSource.removeDataSource();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
