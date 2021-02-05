package com.example.basic.lambda;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 4:43 PM
 * Content:
 */
public class ColorMain {
    public static void main(String[] args) {
       Color color = a -> {
            if (1==a){
                System.out.println("reds");
            }else if (2==a){
                System.out.println("yellow");
            }
        };

        color.show(1);
    }
}
