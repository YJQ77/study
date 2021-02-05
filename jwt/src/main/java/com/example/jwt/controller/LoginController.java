package com.example.jwt.controller;

import com.example.jwt.annotation.UserLoginToken;
import com.example.jwt.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 4:29 PM
 * Content:
 */
@RestController
public class LoginController {

    @Autowired
    JwtConfig jwtConfig;

    @RequestMapping(value = "/login/{username}/{phone}/{password}",method = RequestMethod.POST)
    public String login(@PathVariable String username, @PathVariable String phone, @PathVariable String password){
        String token = jwtConfig.createToken(username, phone, password);
        return token;
    }

    @UserLoginToken
    @RequestMapping(value = "/look",method = RequestMethod.POST)
    public String look(){
        return "hello";
    }

    @UserLoginToken
    @RequestMapping(value = "/look2",method = RequestMethod.POST)
    public String look2(){
        return "hello2";
    }
}
