package com.example.basic.design.abstractFactory;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:06 PM
 * Content:
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColorByType(String orderType) {
        return null;
    }

    @Override
    public Shape getShapeByType(String shapeType) {
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
