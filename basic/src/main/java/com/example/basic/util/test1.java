package com.example.basic.util;

/**
 * Author: YinJiaqi
 * Date: 9/11/2020 10:35 AM
 * Content:
 */
public class test1 {

    public volatile static int i = 100;
    private static final Object lock = new Object();  //表示对象锁
    static class ThreadOne implements Runnable{
        @Override
        public void run() {
            while (i>0){
                synchronized (lock){
                    if (i%2==0) {
                        System.out.println(Thread.currentThread().getName()+"hahaha" + i);
                        i--;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class ThreadTwo implements Runnable{
        @Override
        public void run() {
            while (i>0){
                synchronized (lock){
                    if (i%2==1) {
                        System.out.println(Thread.currentThread().getName()+"hahaha" + i);
                        i--;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
            new Thread(new ThreadOne()).start();
            new Thread(new ThreadTwo()).start();
    }
}
