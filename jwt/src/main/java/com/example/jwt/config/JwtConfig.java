package com.example.jwt.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 2:11 PM
 * Content:
 */
@Component
public class JwtConfig {
    private static final Logger logger = LoggerFactory.getLogger(JwtConfig.class);
    private String header = "token";//token
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private Map<String,String> map = new HashMap<>();
    /**
     * 生成token
     *
     * @param subject
     * @param phone
     * @return
     */
    public String createToken(String subject, String phone, String secret) {
        String token = null;
        try {
            Date date = new Date(System.currentTimeMillis() + (7 * 24 * 3600 * 1000));
            token = Jwts.builder().setSubject(subject)
                    .setIssuedAt(new Date())//创建时间
                    .setExpiration(date)//token过期时间
                    .claim("type", "admin")//身份
                    .claim("username", subject)//用户名
                    .claim("phone", phone)//手机号
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        map.put(subject,token);
        threadLocal.set(token);
        return token;
    }

    /**
     * 根据token获取相关信息
     *
     * @param token
     * @return
     */
    public Claims getTokenInfo(String token, String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 获取用户名
     * @param token
     * @return
     */
    public String getUserName(String token) {
        DecodedJWT decode = JWT.decode(token);
        return decode.getSubject();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ThreadLocal<String> getThreadLocal() {
        return threadLocal;
    }

    public void setThreadLocal(ThreadLocal<String> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
