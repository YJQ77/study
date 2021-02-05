package com.example.basic.design.factory;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:06 PM
 * Content:
 */
public class ShapeFactory {
    public Shape getShape(String shapeType){
        if ("Rectangle".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("Circle".equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if("Square".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }
}
