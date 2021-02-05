package com.example.basic;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Author: YinJiaqi
 * Date: 4/20/2020 2:07 PM
 * Content:
 */
@Component
public class Main {
   public static Random random = new Random();

   @Async
   public Future<String> TaskOne() throws InterruptedException {
       System.out.println("任务一开始：");
       long one = System.currentTimeMillis();
       Thread.sleep(random.nextInt(10000));
       long two = System.currentTimeMillis();
       System.out.println("任务一结束，耗时"+(two-one)+"秒");
       return new AsyncResult<>("任务一结束");
   }
    @Async
    public Future<String> TaskTwo() throws InterruptedException {
        System.out.println("任务二开始：");
        long one = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long two = System.currentTimeMillis();
        System.out.println("任务二结束，耗时"+(two-one)+"秒");
        return new AsyncResult<>("任务二结束");
    }
    @Async
    public Future<String> TaskThree() throws InterruptedException {
        System.out.println("任务三开始：");
        long one = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long two = System.currentTimeMillis();
        System.out.println("任务三结束，耗时"+(two-one)+"秒");
        return new AsyncResult<>("任务三结束");
    }
}
