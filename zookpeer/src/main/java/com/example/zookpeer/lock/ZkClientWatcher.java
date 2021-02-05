package com.example.zookpeer.lock;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author: YinJiaqi
 * Date: 11/2/2020 2:52 PM
 * Content:
 */
public class ZkClientWatcher {
    ZkClient zkClient = null;
    private static final String connect = "172.16.130.82:2181";

    public ZkClientWatcher() {
        this.zkClient = new ZkClient(connect, 3000);
    }

    public void createPersistent(String path, Object data) {
        zkClient.createPersistent(path, data);
    }

    public String createEphemeralSequential(String path, Object data) {
        return zkClient.createEphemeralSequential(path, data);
    }

    public List<String> getChilds(String path) {
        return zkClient.getChildren(path);
    }

    public void writeData(String path, Object object) {
        zkClient.writeData(path, object);

    }

    public void delete(String path) {
        zkClient.delete(path);

    }

    public boolean exists(String path) {
        return zkClient.exists(path);

    }

    public void deleteRecursive(String path) {
        zkClient.deleteRecursive(path);

    }

    /**
     * 对父亲节点增加监听
     *
     * @param path
     */
    public void subscribe(String path) {
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.printf("变更的节点为:%s,数据：%s\r\n", dataPath, data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.printf("删除的节点为:%s\r\n", dataPath);
            }
        });
    }

    /**
     * 对儿子节点增加监听
     *
     * @param path
     */
    public void subscribe2(String path) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("父节点: " + parentPath + ",子节点:" + currentChilds + "\r\n");
            }
        });
    }

    /**
     * 监听客户端
     */
    public void subscribe3(String path) {
        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception {
                if (keeperState.equals(Watcher.Event.KeeperState.SyncConnected)) {
                    System.out.println(connect + "连接zookeeper");
                } else if (keeperState == Watcher.Event.KeeperState.Disconnected) {
                    System.out.println("连接断开");//当我在服务端将zk服务stop时，监听触发
                } else {
                    System.out.println("其他状态" + keeperState);
                }

            }
            @Override
            public void handleNewSession() throws Exception {
            }
            @Override
            public void handleSessionEstablishmentError(Throwable throwable) throws Exception {
            }
        });
    }
}
