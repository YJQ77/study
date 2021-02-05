package com.example.basic.design;


import com.example.basic.design.abstractFactory.FactoryProducer;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:05 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        factoryProducer.getAbstractFactory("color").getColorByType("red").fill();
    }
}
