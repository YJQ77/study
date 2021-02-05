package com.example.basic.design.proxy.staticProxy;

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
        loadImage(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image:" + fileName);
    }

    public void loadImage(String fileName) {
        System.out.println("Loading image:" + fileName);
    }
}
