package com.example.handler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: YinJiaqi
 * Date: 10/19/2020 2:10 PM
 * Content:
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("handler");
        registry.addInterceptor(loginInterceptor)    //指定需要配置的拦截器
                .addPathPatterns("/**") //指定需要拦截的请求  /**  表示拦截所有
//                .excludePathPatterns("/list")  //指定需要排除的请求
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/toLogin")
//                .excludePathPatterns("/toRegister")
                .excludePathPatterns("/*.html");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LoginFilter());
        frBean.addUrlPatterns("/*");
        System.out.println("filter");
        return frBean;
    }

}
