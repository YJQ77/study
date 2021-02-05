package com.example.basic.threadTest;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: YinJiaqi
 * Date: 9/21/2020 2:50 PM
 * Content:
 */
public class CompletionServiceTest {
    private static final int  cpuCount =Runtime.getRuntime().availableProcessors();
    public static ExecutorService poolOne =  Executors.newFixedThreadPool(cpuCount + 1);
    public static ExecutorService poolTwo = Executors.newFixedThreadPool(cpuCount + 1);
    public static CompletionService<Integer> serviceOne = new ExecutorCompletionService<>(poolOne);
    public static CompletionService<String> serviceTwo = new ExecutorCompletionService<>(poolTwo);



    public static void main(String[] args){
        long l = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            SumCount count = new SumCount();
            serviceOne.submit(count);
        }
        for (int i=0;i<100000;i++){
            try {
                Future<Integer> take = serviceOne.take();
                FixedCount count = new FixedCount(take.get());
                serviceTwo.submit(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

    static class SumCount implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Random random = new Random();
            return random.nextInt(500);
        }
    }

    static class FixedCount implements Callable<String> {
        public int count ;
        public FixedCount(int i) {
            this.count = i;
        }
        @Override
        public String call() throws Exception {
           if(count>250){
               return "daadadadada";
           }else{
               return "xiaoxiaoxiaoxiao";
           }
        }
    }
}
