package com.example.runtime.run;

import com.example.runtime.util.ExecutorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 10:18 AM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        //Queue<Long> longQueue  = new LinkedBlockingQueue<>();
        List<Integer> list = new ArrayList<>();
        list.add(7);list.add(8);list.add(9);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);list2.add(5);list2.add(6);
        list2.addAll(0,list);
        list2.forEach(System.out::println);
    }
}
