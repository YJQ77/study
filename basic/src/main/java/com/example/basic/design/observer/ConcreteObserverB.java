package com.example.basic.design.observer;

/**
 * Author: YinJiaqi
 * Date: 10/23/2020 3:46 PM
 * Content:
 */
public class ConcreteObserverB implements Observer {
    @Override
    public void process() {
        System.out.println("具体观察者B处理！");
    }
}
