package com.example.bloomfilter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author: YinJiaqi
 * Date: 11/30/2020 1:30 PM
 * Content:
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Map<Integer, Boolean> monthList = getMonthList();
        System.out.println(monthList);
    }

    public static long getContinuousSignCount() {
        List<Long> list = new ArrayList<>();
        long signCount = 0;
        list.add(15L);
        if (!CollectionUtils.isEmpty(list)) {
            long v = list.get(0) == null ? 0 : list.get(0);
            for (int i = 0; i < 4; i++) {
                if (v >> 1 << 1 == v) {
                    if (i > 0) {
                        break;
                    }
                } else {
                    signCount++;
                }
                v = v >> 1;
            }
        }
        return signCount;
    }

    public static Map<Integer, Boolean> getMonthList() {
        List<Long> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        list.add(239109L);
        if (!CollectionUtils.isEmpty(list)) {
            long v = list.get(0) == null ? 0 : list.get(0);
            for (int i = 18; i > 0; i--) {
                map.put(i, !(v >> 1 << 1 == v));
                v = v>>1;
            }
        }
        return map;
    }
}
