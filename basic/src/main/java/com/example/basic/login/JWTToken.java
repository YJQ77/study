package com.example.basic.login;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Author: YinJiaqi
 * Date: 9/22/2020 5:00 PM
 * Content:
 */
public class JWTToken implements AuthenticationToken {

    //用户行为
    private Integer behavior;
    // 密钥
    private String token;


    public JWTToken(String token,Integer behavior) {
        this.token = token;
        this.behavior = behavior;
    }
    @Override
    public Object getPrincipal() {
        return behavior;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
