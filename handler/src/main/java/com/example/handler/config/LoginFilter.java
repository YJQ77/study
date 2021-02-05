package com.example.handler.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Author: YinJiaqi
 * Date: 10/19/2020 3:02 PM
 * Content:
 */
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //在DispatcherServlet之前执行
        System.out.println("############TestFilter1 doFilterInternal executed############");
        filterChain.doFilter(servletRequest, servletResponse);
        //在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
        System.out.println("############TestFilter1 doFilter after############");
    }
}
