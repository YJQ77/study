package com.example.basic.optional;

/**
 * Author: YinJiaqi
 * Date: 11/16/2020 5:23 PM
 * Content:
 */
public class GenericMethodTest {
   public static <T> T method(T t){
       System.out.println(t);
       return t;
   }
}
