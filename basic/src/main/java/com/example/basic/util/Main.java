package com.example.basic.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 9/16/2020 2:33 PM
 * Content:
 */
public class Main {

    public static void main(String[] args) {
        List<Long> ids  = new ArrayList<>();
        ids.add(51L);
        ids.add(66L);
        ids.add(72L);
        ids.add(73L);
        List<Long> list = subPointList(ids, 66L);
        for (Long i : list){
            System.out.println(i);
        }
    }

    public static List<Long> subPointList(List<Long> pointsId, Long pointId) {
        int i = pointsId.indexOf(pointId);
        List<Long> list;
        if (CollectionUtils.isNotEmpty(pointsId) && pointsId.size() >= 3) {
            if (i == 0) {
                list = pointsId.subList(0, 3);
            } else if (i == pointsId.size() - 1) {
                list = pointsId.subList(i - 2, i+1);
            } else {
                list = pointsId.subList(i - 1, i + 2);
            }
        } else if (CollectionUtils.isNotEmpty(pointsId) && pointsId.size() < 3) {
            list = pointsId;
        } else {
            list = new ArrayList<>();
        }
        return list;
    }
}
