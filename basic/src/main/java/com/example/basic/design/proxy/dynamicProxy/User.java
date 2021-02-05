package com.example.basic.design.proxy.dynamicProxy;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 9:55 AM
 * Content:
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
