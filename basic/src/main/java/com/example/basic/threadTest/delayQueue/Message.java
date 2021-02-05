package com.example.basic.threadTest.delayQueue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Author: YinJiaqi
 * Date: 1/12/2021 4:20 PM
 * Content:
 */
@Data
public class Message implements Delayed {
    private String content;
    private Long fireTime;

    public Message(String content, Long outTime) {
        this.content = content;
        this.fireTime = outTime + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(fireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return content;
    }
}
