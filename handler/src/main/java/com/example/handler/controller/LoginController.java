package com.example.handler.controller;

import com.example.handler.config.NeedLogin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: YinJiaqi
 * Date: 10/19/2020 2:15 PM
 * Content:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @NeedLogin
    @RequestMapping("/login")
    public String login(){
        System.out.println("view is hello");
        return "success";
    }
}
