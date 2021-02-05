package com.example.basic.base;

/**
 * Author: YinJiaqi
 * Date: 10/27/2020 3:03 PM
 * Content:
 */
public class Dog extends Animal {
    public Dog() {
        name = "dog";
        age = 12;
    }

    @Override
    public void kinds() {
        System.out.println("I am a dog");
    }
}
