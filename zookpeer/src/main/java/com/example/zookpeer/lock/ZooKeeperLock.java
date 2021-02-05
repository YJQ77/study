package com.example.zookpeer.lock;

/**
 * Author: YinJiaqi
 * Date: 10/27/2020 2:15 PM
 * Content:
 */
public interface ZooKeeperLock {
    /**
     * 尝试获取锁
     *
     * @param guidNodeName 用于加锁的唯一节点名
     * @return
     */
    void lock(String guidNodeName);

    /**
     * 释放锁
     *
     * @return
     */
    void unlock();

    /**
     * 锁是否已经存在
     *
     * @param guidNodeName 用于加锁的唯一节点名
     * @return
     */
    boolean exists(String guidNodeName);
}
