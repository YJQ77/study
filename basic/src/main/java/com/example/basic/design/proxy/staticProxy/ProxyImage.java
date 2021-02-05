package com.example.basic.design.proxy.staticProxy;

/**
 * Author: YinJiaqi
 * Date: 10/23/2020 2:53 PM
 * Content:
 */
public class ProxyImage implements Image {

    private RealImage realImage;

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage("lalala");
        }
        preDisplay();
        realImage.display();
        afterDisplay();
    }
    public void preDisplay(){
        System.out.println("pre");
    }

    public void afterDisplay(){
        System.out.println("after");
    }
}
