package com.example.basic.optional;

/**
 * Author: YinJiaqi
 * Date: 11/16/2020 5:23 PM
 * Content:
 */
public class GenericClassTest<T> {
    private T t;

    public GenericClassTest(T t) {
        this.t = t;
    }

    public  boolean isNow(){
        if (t instanceof StudentDTO){
            return true;
        }
        return false;
    }
}
