package com.example.bloomfilter.config;

/**
 * Author: YinJiaqi
 * Date: 12/2/2020 11:12 AM
 * Content:
 */
public class BaseExpection extends RuntimeException {

    public BaseExpection(){
        super();
    }

    public BaseExpection(String message) {
        super(message);
    }
}
