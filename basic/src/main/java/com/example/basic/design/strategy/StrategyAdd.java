package com.example.basic.design.strategy;

/**
 * Author: YinJiaqi
 * Date: 10/22/2020 4:27 PM
 * Content:
 */
public class StrategyAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
