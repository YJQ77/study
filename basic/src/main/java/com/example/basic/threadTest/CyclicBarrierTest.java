package com.example.basic.threadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: YinJiaqi
 * Date: 9/4/2020 9:53 AM
 * Content:
 */
public class CyclicBarrierTest {
    public static List<Integer> num = new ArrayList<>();
    static class TotalCount extends Thread{
        @Override
        public void run() {
          System.out.println(Thread.currentThread().getName()+"开始计算总的");
          int total = 0;
          for (Integer i : num){
              total = total + i;
          }
            System.out.println(Thread.currentThread().getName()+"计算结束"+total);
        }
    }

    static class NumCount extends Thread{
        CyclicBarrier cyclicBarrier;
        int index;
        public NumCount(CyclicBarrier cyclicBarrier,int index){
            this.cyclicBarrier = cyclicBarrier;
            this.index = index;
        }
        @Override
        public void run() {
            try {
                int count = 0;
                for (int i = 10;i>=index;i--){
                    count = count +i;
                }
                System.out.println(Thread.currentThread().getName()+"开始计算");
                num.add(count);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"开始计算别的");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new TotalCount());
        for (int i=0;i<=4;i++){
            new NumCount(cyclicBarrier,i).start();
        }

//        MultiValuedMap<String,Integer> map = new ArrayListValuedHashMap();
//        map.put("one",123456);
//        map.put("one",123457);
//        map.put("one",123458);
//        map.put("one",123459);
//        System.out.println(map.get("one"));
    }

}
