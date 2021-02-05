package com.example.basic.design.proxy.dynamicProxy;


/**
 * Author: YinJiaqi
 * Date: 10/23/2020 2:22 PM
 * Content:
 */
public class RealImage2 implements Image {
    private String fileName;

    public RealImage2() {
    }
    public RealImage2(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void display() {
        System.out.println("Displaying image2:" + fileName);
    }

    @Override
    public User display2() {
        return new User(2,"yinjiaqi");
    }

}
