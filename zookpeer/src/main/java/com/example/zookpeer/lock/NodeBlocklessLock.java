package com.example.zookpeer.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Author: YinJiaqi
 * Date: 10/27/2020 2:19 PM
 * Content: 基于节点实现的非阻塞锁
 */
public class NodeBlocklessLock implements ZooKeeperLock {

    private ZkClientWatcher zkClientWatcher;
    private static ThreadLocal<String> preNode = new ThreadLocal<>();
    private static ThreadLocal<String> currentNode = new ThreadLocal<>();

    public NodeBlocklessLock() {
        zkClientWatcher = new ZkClientWatcher();
    }

    @Override
    public void lock(String guidNodeName) {
        if (!trylock(guidNodeName)) {
            waitlock();
            lock(guidNodeName);
        }
    }

    public boolean trylock(String guidNodeName) {
        if (!zkClientWatcher.exists(guidNodeName)) {
            zkClientWatcher.createPersistent(guidNodeName, "lock");
        }
        if (currentNode.get() == null || "".equalsIgnoreCase(currentNode.get())) {
            String lock = zkClientWatcher.createEphemeralSequential(guidNodeName + "/", "lock");
            System.out.println("lock:" + lock);
            currentNode.set(lock);
        }
        List<String> childs = zkClientWatcher.getChilds(guidNodeName);
        Collections.sort(childs);
        if ((guidNodeName + "/" + childs.get(0)).equals(currentNode.get())) {
            return true;
        }
        preNode.set(guidNodeName + "/" + childs.get(childs.indexOf(currentNode.get().substring(guidNodeName.length() + 1)) - 1));
        System.out.println("preNode:"+preNode.get());
        return false;
    }

    public void waitlock() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s + "释放锁");
                countDownLatch.countDown();
            }
        };
        zkClientWatcher.zkClient.subscribeDataChanges(preNode.get(), listener);
        try {
            if (exists(preNode.get())) {
                countDownLatch.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClientWatcher.zkClient.unsubscribeDataChanges(preNode.get(), listener);
    }

    @Override
    public void unlock() {
        if (zkClientWatcher.exists(currentNode.get())) {
            zkClientWatcher.delete(currentNode.get());
            currentNode.remove();
            preNode.remove();
        }
    }

    @Override
    public boolean exists(String guidNodeName) {
        return zkClientWatcher.exists(guidNodeName);
    }
}
