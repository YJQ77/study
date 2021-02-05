package com.example.basic.design.strategy;

/**
 * Author: YinJiaqi
 * Date: 10/10/2020 4:05 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        Content content = null;

        content = new Content(new StrategyAdd());
        System.out.println("10 + 20 = "+content.doSomething(10,20));

        content = new Content(new StrategySubtract());
        System.out.println("10 - 20 = "+content.doSomething(10,20));

        content = new Content(new StrategyMultiply());
        System.out.println("10 * 20 = "+content.doSomething(10,20));
    }
}
