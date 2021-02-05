package com.example.bloomfilter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: YinJiaqi
 * Date: 12/1/2020 3:26 PM
 * Content:
 */
@Aspect
@Component
public class AspectTest {

    @Pointcut(value = "execution(* com.example.bloomfilter.service..*(..))")
    public void pointCut(){}

//    @Around(value = "pointCut()")
//    public void around(ProceedingJoinPoint joinPoint){
//        System.out.println("start");
//        try {
//            Object proceed = joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("end");
//    }

    @Before(value = "pointCut()")
    public void before(){
        System.out.println("start");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "returnValue")
    public void After(Object returnValue){
        System.out.println("end");
        Integer a = (Integer) returnValue;
        System.out.println(a);
    }
}
