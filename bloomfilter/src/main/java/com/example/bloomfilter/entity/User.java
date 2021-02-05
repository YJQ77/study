package com.example.bloomfilter.entity;

import lombok.Data;

import java.lang.reflect.ParameterizedType;

/**
 * Author: YinJiaqi
 * Date: 11/18/2020 11:10 AM
 * Content:
 */
@Data
public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
