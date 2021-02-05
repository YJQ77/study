package com.example.basic.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: YinJiaqi
 * Date: 9/11/2020 10:35 AM
 * Content:
 */
public class test2 {
    public static int index = 0;
    public static Lock lock = new ReentrantLock();

    static class ThreadOne extends Thread {
        @Override
        public void run() {
            int i = 0;
            while(i <= 10) {
                try {
                    lock.lock();
                    while (index % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": A");
                        i++;
                        index++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadTwo extends Thread {
        @Override
        public void run() {
            int i = 0;
            while(i <= 10) {
                try {
                    lock.lock();
                    while (index % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": B");
                        i++;
                        index++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadThree extends Thread {
        @Override
        public void run() {
            int i = 0;
            while(i <= 10) {
                try {
                    lock.lock();
                    while (index % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + ": C");
                        i++;
                        index++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadOne().start();
        new ThreadTwo().start();
        new ThreadThree().start();
    }
}
