package com.example.basic.design.abstractFactory;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:20 PM
 * Content:
 */
public abstract class AbstractFactory {
   public abstract Color getColorByType(String orderType);
   public abstract Shape getShapeByType(String shapeType);
}
