package com.example.basic.design.decorator;


/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:03 PM
 * Content:
 */
public class Rectangle implements ShapeDec {
    @Override
    public void draw() {
        System.out.println("draw is Rectangle!");
    }
}
