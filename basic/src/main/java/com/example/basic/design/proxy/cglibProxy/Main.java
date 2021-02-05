package com.example.basic.design.proxy.cglibProxy;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 10:41 AM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        Image image = new RealImage();
        ProxyImage proxyImage = new ProxyImage();
        Image proxy = (Image)proxyImage.getProxyObject(image);
        proxy.disPlay();
    }
}
