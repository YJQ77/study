package com.example.basic.design.TemplatePattern;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 4:57 PM
 * Content:
 */
public class BannerProducer extends Shop {
    @Override
    Food getFood() {
        Food food = new Food();
        food.setName("banner");
        return food;
    }
}
