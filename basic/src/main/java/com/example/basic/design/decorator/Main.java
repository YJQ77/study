package com.example.basic.design.decorator;

/**
 * Author: YinJiaqi
 * Date: 10/16/2020 2:59 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        ShapeDec circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle of red border");
        redCircle.draw();

        System.out.println("Rectangle of red border");
        redRectangle.draw();
    }
}
