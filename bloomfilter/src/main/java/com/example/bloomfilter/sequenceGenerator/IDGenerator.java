package com.example.bloomfilter.sequenceGenerator;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Author: YinJiaqi
 * Date: 11/26/2020 10:28 AM
 * Content:
 */
@Component
public class IDGenerator {
    private static Map<String, Queue<Long>> seqMap = new ConcurrentHashMap<>();
    private static long count = 200;
    private static String prefix = "ids_";
    private static Jedis jedis;

    static {
        jedis = new Jedis("172.16.129.118", 6379);
        jedis.auth("k12");
    }

    public Long getId(String code) {
        Queue<Long> queue = getQueue(code);
        Long poll = queue.poll();
        if (poll == null) {
            synchronized (code.intern()) {
                poll = queue.poll();
                if (poll == null) {
                    refresh(code, queue);
                }
                poll = queue.poll();
            }
        }
        return poll;
    }

    public void refresh(String code, Queue<Long> queue) {
        int a = 200;
        Long end = jedis.incrBy(prefix + code, count);
        if (end <= a) {
            end = jedis.incrBy(prefix + code, a+count);
        }
        Long start = end - count + 1;
        for (long i = start; i <= end; i++) {
            queue.add(i);
        }
        jedis.close();
    }

    public Queue<Long> getQueue(String code) {
        if (!seqMap.containsKey(code)) {
            synchronized (code.intern()) {
                if (!seqMap.containsKey(code)) {
                    seqMap.put(code, new LinkedBlockingQueue<>());
                }
            }
        }
        return seqMap.get(code);
    }

    public String lpad(int length, long number) {
        String f = "%0" + length + "d";
        return String.format(f, number);
    }
}
