package com.example.basic.base;

import java.util.Comparator;

/**
 * Author: YinJiaqi
 * Date: 10/27/2020 3:10 PM
 * Content:
 */
public class Bird extends Animal {

    public Bird() {
        name = "bird";
        age = 13;
    }

    @Override
    public void kinds() {
        System.out.println("I am a bird");
    }

}
