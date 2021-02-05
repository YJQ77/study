package com.example.zookpeer.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 11/2/2020 2:26 PM
 * Content:
 */
public class ZKClientDemo {
    private static final String connect = "172.16.130.82:2181";
    private static final String nodePath = "/james";
    private static final String otherPath = "/peter";

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(connect, 3000);
        //zkClient.create(nodePath, "hello", CreateMode.PERSISTENT);
        System.out.println("是否存在" + zkClient.exists("/james0000000007"));
        zkClient.delete("/james0000000007");
        //zkClient.createPersistent(nodePath+"/a/b/c",true);
        //zkClient.createPersistent(nodePath+"/d/e",true);
//        zkClient.createPersistent(otherPath , "nihao");
//        System.out.println(zkClient.readData(otherPath).toString());
//        List<String> children = zkClient.getChildren(nodePath);
//        children.forEach(System.out::println);
        zkClient.deleteRecursive(nodePath);
    }
}
