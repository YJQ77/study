package com.example.basic.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: YinJiaqi
 * Date: 9/22/2020 4:38 PM
 * Content:
 */
public class JWTUtil {
    // 过期时间
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    private static final String USERNAME = "username";

    private static final String TYPE = "type";

    /**
     * 生成token
     * @param username
     * @param password
     * @return
     */
    public static String createToken(String username, String password) {
        String token = null;
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(password);
            token = JWT.create().
                    withClaim(USERNAME, username).
                    withClaim(TYPE, 0).
                    withExpiresAt(date).sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 校验token
     * @param token
     * @param username
     * @param password
     * @return
     */
    public static boolean vieryToken(String token,String username,String password){
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier build = JWT.require(algorithm).withClaim(USERNAME, username).build();
            build.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
           return false;
        }
    }

    public static String getUsername(String token){
        DecodedJWT decode = JWT.decode(token);
        String username = decode.getClaim(USERNAME).asString();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(decode.getExpiresAt());
        return username + date;
    }
}
