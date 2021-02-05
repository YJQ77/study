package com.example.basic.optional;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 11/16/2020 5:18 PM
 * Content:
 */
@Data
public class StudentDTO {
    private Integer id;
    private String name;

    public StudentDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
