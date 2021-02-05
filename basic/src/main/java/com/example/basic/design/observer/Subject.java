package com.example.basic.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 10/23/2020 3:47 PM
 * Content:
 */
public abstract class Subject {
    protected List<Observer> list = new ArrayList<Observer>();

    public void addObserver(Observer observer){
        list.add(observer);
    }

    public void removeObserver(Observer observer){
        list.remove(observer);
    }

    public abstract void notifyObserver();
}
