package com.example.auth.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Integer id;

    private String userName;

    private String password;

    private String role;
}