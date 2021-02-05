package com.example.basic.lambda;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: YinJiaqi
 * Date: 10/27/2020 3:05 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        Processor p = (a, b) -> add(a, b);
        System.out.println(p.getStringLength(2, 5));
        Integer[] a = {4, 5, 4, 9, 8, 52, 7, 2, 6, 9, 4, 5, 6, 11, 22, 8, 6, 6, 99, 85, 75, 48, 6, 2, 45, 89, 12, 48, 65, 32, 88, 44, 11, 15, 62, 5871, 5224, 56, 95, 1, 2};
        List<Integer> list = Arrays.asList(a);
        List<Integer> collect = list.stream().filter(s -> s > 4).collect(Collectors.toList());
        Set<Integer> collect1 = list.stream().map(s -> s * s).collect(Collectors.toSet());
        Stream<Integer> sorted = list.stream().sorted();
        long count = list.stream().filter(s -> s > 4).count();
        //System.out.println(count);
        sorted.forEach(System.out::println);


        Processor processor = (x, y) -> add(x,y);
        System.out.println("labama" + processor.getStringLength(3, 2));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    interface Processor {
        int getStringLength(int a, int b);
    }

    interface Processor2 {
        int getStringLength(int a, int b);
    }

}
