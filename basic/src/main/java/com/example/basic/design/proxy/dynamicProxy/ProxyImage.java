package com.example.basic.design.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: YinJiaqi
 * Date: 11/6/2020 11:06 AM
 * Content:
 */
public class ProxyImage {
    private Object object;

    public ProxyImage(Object object) {
        this.object = object;
    }

    public Object getProxyObject2(){
        Object o = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("aaa");
                User invoke = (User)method.invoke(object, args);
                System.out.println(invoke);
                System.out.println("bbb");
                return object;
            }
        });
        return o;
    }
}
