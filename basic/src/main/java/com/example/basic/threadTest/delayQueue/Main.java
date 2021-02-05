package com.example.basic.threadTest.delayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * Author: YinJiaqi
 * Date: 1/12/2021 4:26 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Message> queue = new DelayQueue<>();
        queue.put(new Message("hello", 10000L));
        queue.put(new Message("word", 15000L));
        queue.put(new Message("start", 5000L));
        while (!queue.isEmpty()){
            System.out.println(queue.take());
        }
    }
}
