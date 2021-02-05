package com.example.basic.optional;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 11/16/2020 5:25 PM
 * Content:
 */
@Data
public class Student2 {
    private Integer id;
    private String name;

    public Student2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
