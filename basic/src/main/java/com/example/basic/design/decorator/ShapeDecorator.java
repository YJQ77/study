package com.example.basic.design.decorator;


/**
 * Author: YinJiaqi
 * Date: 10/16/2020 2:53 PM
 * Content:
 */
public abstract class ShapeDecorator implements ShapeDec{
    protected ShapeDec shapeDec;

    public ShapeDecorator(ShapeDec shapeDec) {
        this.shapeDec = shapeDec;
    }
}
