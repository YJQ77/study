package com.example.basic.design.proxy.dynamicProxy;


/**
 * Author: YinJiaqi
 * Date: 10/23/2020 2:22 PM
 * Content:
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage() {
    }
    public RealImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void display() {
        System.out.println("Displaying image:" + fileName);
    }
    @Override
    public User display2() {
        return new User(1,"yinjiaqi");
    }
}
