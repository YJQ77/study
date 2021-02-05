package com.example.jwt;

import com.example.jwt.config.JwtConfig;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private JwtConfig jwtConfig;
    @Test
    void contextLoads() {
    }

    @Test
    void JwtTest() {
        String password = "yjqstc31017";
        String token = jwtConfig.createToken("yinjiaqi", "15258063078",password);
        System.out.println(token);
        Claims tokenInfo = jwtConfig.getTokenInfo(token, password);
        System.out.println(tokenInfo.get("username"));
        System.out.println(tokenInfo.get("phone"));
    }

}
