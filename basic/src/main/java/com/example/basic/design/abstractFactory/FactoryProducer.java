package com.example.basic.design.abstractFactory;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:24 PM
 * Content:
 */
public class FactoryProducer {
    public AbstractFactory getAbstractFactory(String choice){
        if("shape".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        } else if("color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
