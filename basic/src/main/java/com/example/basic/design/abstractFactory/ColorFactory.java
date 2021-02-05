package com.example.basic.design.abstractFactory;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:17 PM
 * Content:
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColorByType(String orderType) {
        if ("red".equalsIgnoreCase(orderType)){
            return new Red();
        }else if("blue".equalsIgnoreCase(orderType)){
            return new Blue();
        }else if("yellow".equalsIgnoreCase(orderType)){
            return new Yellow();
        }
        return null;
    }

    @Override
    public Shape getShapeByType(String shapeType) {
        return null;
    }
}
