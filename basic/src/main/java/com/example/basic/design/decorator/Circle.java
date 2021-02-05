package com.example.basic.design.decorator;


/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:04 PM
 * Content:
 */
public class Circle implements ShapeDec {
    @Override
    public void draw() {
        System.out.println("draw is Circle!");
    }
}
