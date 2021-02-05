package com.example.basic.entity;

import lombok.Data;

import java.util.Date;

/**
 * Author: YinJiaqi
 * Date: 4/20/2020 2:12 PM
 * Content:
 */
@Data
public class Message {
    private Long id;
    private String msg;
    private Date sendTime;
}
