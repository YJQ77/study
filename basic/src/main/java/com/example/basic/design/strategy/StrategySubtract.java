package com.example.basic.design.strategy;

/**
 * Author: YinJiaqi
 * Date: 10/22/2020 4:28 PM
 * Content:
 */
public class StrategySubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num2 - num1;
    }
}
