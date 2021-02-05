package com.example.basic.design.strategy;

/**
 * Author: YinJiaqi
 * Date: 10/22/2020 4:32 PM
 * Content:
 */
public class Content {
    private Strategy strategy;

    public Content(Strategy strategy) {
        this.strategy = strategy;
    }

    public int doSomething(int num,int num2){
        return strategy.doOperation(num,num2);
    }
}
