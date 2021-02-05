package com.example.basic.design.decorator;

/**
 * Author: YinJiaqi
 * Date: 10/16/2020 2:56 PM
 * Content:
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(ShapeDec shapeDec) {
        super(shapeDec);
    }

    @Override
    public void draw() {
        shapeDec.draw();
        setName(shapeDec);
    }

    public void setColor(ShapeDec shapeDec) {
        System.out.println("Color is Red");
    }

    public void setName(ShapeDec shapeDec) {
        System.out.println("name is Red");
        shapeDec.draw();
    }
}
