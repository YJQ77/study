package com.example.handler.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: YinJiaqi
 * Date: 10/19/2020 2:08 PM
 * Content:
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = Boolean.FALSE;
        if (handler instanceof HandlerMethod   //先判断是不是controller中的方法
                &&((HandlerMethod)handler).getMethodAnnotation(NeedLogin.class)!= null){  //再判断是不是@NeedLogin的注解
            //如果获取不到 NeedLogin注解，说明该方法没有被注解标识，说明不需要进行登录校验。
            if (request.getHeader("mac_code").equalsIgnoreCase("123456")){
                flag =  true;
                System.out.println("bbbb");
            }
        }else{
            flag = true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("aaa");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("cccc");
    }
}
