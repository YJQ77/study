package com.example.jwt.config;

import com.example.jwt.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 2:12 PM
 * Content:
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            if (((HandlerMethod) handler).getMethodAnnotation(UserLoginToken.class) != null){
                if (StringUtils.isEmpty(request.getHeader(jwtConfig.getHeader()))){
                    response.sendError(400,"请登录");
                    return false;
                }
                if (StringUtils.isEmpty(jwtConfig.getMap().get(jwtConfig.getUserName(request.getHeader(jwtConfig.getHeader()))))){
                    response.sendError(400,"token 已过期");
                    return false;
                }
                if(!jwtConfig.getMap().get(jwtConfig.getUserName(request.getHeader(jwtConfig.getHeader()))).equalsIgnoreCase(request.getHeader(jwtConfig.getHeader()))){
                    response.sendError(400,"账号已在别地登录");
                }
                return true;
            }
        }
        return true;
    }
}
