package com.example.basic.design.observer;

/**
 * Author: YinJiaqi
 * Date: 10/23/2020 3:51 PM
 * Content:
 */
public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        System.out.println("具体目标正在改变：");
        for (Observer observer : list) {
            observer.process();
        }
    }
}
