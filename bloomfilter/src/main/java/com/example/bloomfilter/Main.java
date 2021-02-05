package com.example.bloomfilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Author: YinJiaqi
 * Date: 12/3/2020 11:56 AM
 * Content:
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int a = 0;
//        while (scanner.hasNextInt()){
//           a = a+scanner.nextInt();
//        }
//        System.out.println("hello word:"+a);
        Runtime runtime = Runtime.getRuntime();
        Process exec;
        Process exec2;
        try {
            exec = runtime.exec("javac G:\\Main.java");
            exec2 = runtime.exec("java G:\\Main");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("出错了");
        }
        InputStream inputStream = exec2.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String read = null;
        while ((read = bf.readLine()) != null) {
            System.out.println(read);
        }
    }
}
