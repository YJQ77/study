package com.example.basic.design.proxy.cglibProxy;

import com.example.basic.design.proxy.dynamicProxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: YinJiaqi
 * Date: 11/9/2020 10:35 AM
 * Content:
 */
public class ProxyImage implements MethodInterceptor {
    private Object object;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("aaa");
        User invoke = (User) method.invoke(object, objects);
        System.out.println(invoke);
        System.out.println("bbb");
        return invoke;
    }

    public Object getProxyObject(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
