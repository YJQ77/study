package com.example.basic.design.proxy.cglibProxy;

import com.example.basic.design.proxy.dynamicProxy.User;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 10:31 AM
 * Content:
 */
public class RealImage implements Image {
    @Override
    public User disPlay() {
        return new User(1,"shenyiding");
    }
}
