package com.example.basic.base;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 11/25/2020 5:25 PM
 * Content:
 */
@Data
public class Student {
    private Integer id;
    private String name;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
