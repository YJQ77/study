package com.example.basic.base;

import org.springframework.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Author: YinJiaqi
 * Date: 10/27/2020 3:05 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Animal a = new Dog();
//        a.kinds();
//        System.out.println(Animal.name +"---"+ Animal.age);
//
//        Animal b = new Bird();
//        b.kinds();
//        System.out.println(Animal.name +"---"+ Animal.age);
//
//        int i = Math.abs("shuaige-group".hashCode()) % 50;
//        System.out.println(i);
//        Class<Student> studentClass = Student.class;
//        Student student = studentClass.newInstance();
//        student.setName("yinjiaqi");
//        System.out.println(student.getName());
//
//        Constructor<Student> constructor = studentClass.getConstructor();
//        Student student1 = constructor.newInstance();
//        student1.setName("aaa");
//        System.out.println(student1.getName());
//
//        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(Integer.class, String.class);
//        Student bbb = declaredConstructor.newInstance(1, "bbb");
//        System.out.println(bbb.getId()+bbb.getName());

        //System.out.println(climbStairs(4));
       // System.out.println(getTime(7));
       // System.out.println(findTheDifference("asc","ascf"));
        int [] A = {1,2,3,4,5,6};
        int [] B = new int[6];
        int [] C = new int[6];
        hanota(A,B,C);
        for (int i : C) {
            System.out.println(i);
        }
    }

    public static void hanota(int[] A, int[] B, int[] C) {
        int n = A.length;
        Stack<Integer> a = new Stack<>();
        for (int i = 0; i < n; ++i) {
            a.push(A[i]);
        }
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        hanota(n, a, b, c);
    }


    private  static void hanota(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n == 1) {
            c.push(a.pop());
            return;
        }
        hanota(n - 1, a, c, b);
        c.push(a.pop());
        hanota(n - 1, b, a, c);
    }

    public static Date getTime(int week) {

        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK) ;
        week = week + 1;
        int abs = 0;
        if (weekday > week) {
            abs = 7+week - weekday;
        } else {
            abs = week - weekday;
        }
        c.add(Calendar.DATE, abs);
        return c.getTime();
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        /*
            初始化 dp数组，因为要保存0级台阶，所以长度为 n+1
            dp[i]表示 第i级台阶 一共有 dp[i] 种到达情况
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            /*
                到达当前台阶的情况有如下两种：
                    1、上一级台阶 跨一步
                    2、上一级的上一级的台阶 跨两步
             */
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static char findTheDifference(String s, String t) {
        char[] charArr = s.concat(t).toCharArray();
        char res = 0;
        for (char c : charArr) {
            res ^= c;
        }
        return res;
    }
}

class ParkingSystem {
    int a;
    int b;
    int c;

    public ParkingSystem(int big, int medium, int small) {
        this.a = big;
        this.b = medium;
        this.c = small;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = allowed.toCharArray();
        for (String s:words){
            for (char c:chars){
                 s.replace(c,c);
            }
        }
        return 0;
    }
    public boolean addCar(int carType) {
        boolean flag = true;
        switch(carType){
            case 1:
                if(a<1){
                    flag = false;
                }
                a--;
                break;
            case 2:
                if(b<1){
                    flag = false;
                }
                b--;
                break;
            case 3:
                if(c<1){
                    flag = false;
                }
                c--;
                break;
        }
        return flag;
    }
}

