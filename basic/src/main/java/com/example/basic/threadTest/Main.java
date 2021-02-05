package com.example.basic.threadTest;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: YinJiaqi
 * Date: 8/20/2020 1:24 PM
 * Content:
 */
public class Main {
    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] sort2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
        return a;
    }

    public static int[] sort3(int[] a) {
        if (a.length < 3) {
            return sort2(a);
        }
        int mid = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        return merage(sort3(left), sort3(right));
    }

    public static int[] merage(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int index = 0, i = 0, j = 0; index < (left.length + right.length); index++) {
            if(i>=left.length){
                result[index] = right[j++];
            }
            else if(j>=right.length){
                result[index] = left[i++];
            }
            else if(left[i]>right[j]){
                result[index] = right[j++];
            }
            else {
                result[index] = left[i++];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4,5,4,9,8,52,7,2,6,9,4,5,6,11,22,8,6,6,99,85,75,48,6,2,45,89,12,48,65,32,88,44,11,15,62,5871,5224,56,95,1,2};
        int[] sort = sort3(a);
//        int[] a = {4, 4, 5, 5, 5};
//        int[] b = {2, 6, 7, 9, 9};
//        int[] sort = merage(a, b);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + ",");
        }

    }
}
