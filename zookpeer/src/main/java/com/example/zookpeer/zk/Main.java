package com.example.zookpeer.zk;

/**
 * Author: YinJiaqi
 * Date: 11/2/2020 11:15 AM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        String path = "/xuqiong/shenyiding";
        String paths[] = path.substring(1,path.length()).split("/");
        for(int i=0;i<paths.length;i++){
            String childPath = "";
            for(int j=0;j<=i;j++){
                childPath += "/" + paths[j];
            }
            System.out.println(childPath);
        }

    }
}
