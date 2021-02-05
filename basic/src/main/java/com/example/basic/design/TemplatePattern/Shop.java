package com.example.basic.design.TemplatePattern;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 4:52 PM
 * Content:
 */
public abstract class Shop {

    public void createFood(){
        System.out.println("welcome");
        Food food = getFood();
        System.out.println(food);
    }

    abstract Food getFood();
}
