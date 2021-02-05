package com.example.basic.login;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 9/22/2020 5:04 PM
 * Content:
 */
@Data
public class UserDto {
    private String username;

    private String password;

    private String token;
}
