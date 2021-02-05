package com.example.jwt.annotation;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 2:12 PM
 * Content:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface UserLoginToken {
    boolean forceAuth() default true;
}
