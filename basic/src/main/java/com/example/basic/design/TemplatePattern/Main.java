package com.example.basic.design.TemplatePattern;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 4:55 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new AppleProducer();
        shop.createFood();
        shop = new BannerProducer();
        shop.createFood();
    }
}
