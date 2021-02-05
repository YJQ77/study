package com.example.basic.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: YinJiaqi
 * Date: 8/20/2020 1:24 PM
 * Content:
 */
public class Main {
//    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
//    private static int state = 0;//通过state的值来确定是否打印
//
//    static class ThreadA extends Thread {
//        @Override
//        public void run() {
//            for (int i = 0; i < 10;) {
//                try {
//                    lock.lock();
//                    while (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
//                        System.out.print("A");
//                        state++;
//                        i++;
//                    }
//                } finally {
//                    lock.unlock();// unlock()操作必须放在finally块中
//                }
//            }
//        }
//    }
//
//    static class ThreadB extends Thread {
//        @Override
//        public void run() {
//            for (int i = 0; i < 10;) {
//                try {
//                    lock.lock();
//                    while (state % 3 == 1) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
//                        System.out.print("B");
//                        state++;
//                        i++;
//                    }
//                } finally {
//                    lock.unlock();// unlock()操作必须放在finally块中
//                }
//            }
//        }
//    }
//
//    static class ThreadC extends Thread {
//        @Override
//        public void run() {
//            for (int i = 0; i < 10;) {
//                try {
//                    lock.lock();
//                    while (state % 3 == 2) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
//                        System.out.print("C");
//                        state++;
//                        i++;
//                    }
//                } finally {
//                    lock.unlock();// unlock()操作必须放在finally块中
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new ThreadB().start();
//        new ThreadA().start();
//
//        new ThreadC().start();
//    }
        public static class ThreadPrinter implements Runnable {
            private String name;
            private Object prev;
            private Object self;
            private ThreadPrinter(String name, Object prev, Object self) {
                this.name = name;
                this.prev = prev;
                this.self = self;
            }
            @Override
            public void run() {
                int count = 10;
                while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                    synchronized (prev) { // 先获取 prev 锁
                        synchronized (self) {// 再获取 self 锁
                            System.out.print(name);//打印
                            count--;
                            self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                        }
                        //此时执行完self的同步块，这时self锁才释放。
                        try {
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                            /**
                             * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                             */
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        public static void main(String[] args) throws Exception {
            Object a = new Object();
            Object b = new Object();
            Object c = new Object();
            ThreadPrinter pa = new ThreadPrinter("A", c, a);
            ThreadPrinter pb = new ThreadPrinter("B", a, b);
            ThreadPrinter pc = new ThreadPrinter("C", b, c);


            new Thread(pa).start();
            Thread.sleep(10);//保证初始ABC的启动顺序
            new Thread(pb).start();
            Thread.sleep(10);
            new Thread(pc).start();
            Thread.sleep(10);


        }
    }
