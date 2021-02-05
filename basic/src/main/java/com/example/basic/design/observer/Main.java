package com.example.basic.design.observer;

/**
 * Author: YinJiaqi
 * Date: 10/23/2020 3:54 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        ConcreteObserverA a = new ConcreteObserverA();
        ConcreteObserverB b =new ConcreteObserverB();
        Subject subject = new ConcreteSubject();
        subject.addObserver(a);subject.addObserver(b);
       ((ConcreteSubject) subject).setState(0);
    }
}
