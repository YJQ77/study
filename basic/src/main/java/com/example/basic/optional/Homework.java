package com.example.basic.optional;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 11/16/2020 5:37 PM
 * Content:
 */
@Data
public class Homework {
    private Integer homeworkId;
    private String homeworkName;

    public Homework(Integer homeworkId, String homeworkName) {
        this.homeworkId = homeworkId;
        this.homeworkName = homeworkName;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "homeworkId=" + homeworkId +
                ", homeworkName='" + homeworkName + '\'' +
                '}';
    }
}
