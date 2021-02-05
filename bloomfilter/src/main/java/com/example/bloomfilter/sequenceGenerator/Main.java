package com.example.bloomfilter.sequenceGenerator;//package com.example.basic.sequenceGenerator;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.Jedis;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * Author: YinJiaqi
// * Date: 11/26/2020 10:09 AM
// * Content:
// */
//public class Main {
//    private static CountDownLatch countDownLatch = new CountDownLatch(50);
//    private static Logger logger = LoggerFactory.getLogger(Main.class);
//
//    public static void main(String[] args) {
//        for (int i = 1; i <= 50; i++) {
//            new Thread(new seqNoThread("thread" + i, countDownLatch)).start();
//            countDownLatch.countDown();
//        }
//    }
//
//    static class seqNoThread implements Runnable {
//        private String name;
//        private CountDownLatch countDownLatch;
//
//        public seqNoThread(String name, CountDownLatch countDownLatch) {
//            this.name = name;
//            this.countDownLatch = countDownLatch;
//        }
//
//        @Override
//        public void run() {
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                logger.error(e.getMessage(), e);
//            }
//            Long masterno = IDGenerator.getId("masterno");
//            System.out.println(name + "获取id：" + masterno);
//        }
//    }
//}
//
