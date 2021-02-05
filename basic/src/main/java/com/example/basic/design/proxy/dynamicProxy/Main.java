package com.example.basic.design.proxy.dynamicProxy;

/**
 * Author: YinJiaqi
 * Date: 10/23/2020 3:13 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
//        Image image = new RealImage("james");
//        ProxyImage proxyImage = new ProxyImage(image);
//        Object proxyObject = proxyImage.getProxyObject();
//        Image image1 = (Image) proxyObject;
//        image1.display();


        Image image2 = new RealImage2();
        ProxyImage proxyImage =  new ProxyImage(image2);
        Object proxyObject = proxyImage.getProxyObject2();
        image2 = (Image) proxyObject;
        User user = image2.display2();
    }
}
