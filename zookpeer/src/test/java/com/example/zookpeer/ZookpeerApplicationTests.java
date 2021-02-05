package com.example.zookpeer;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
class ZookpeerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void zookeeper() throws InterruptedException {
        String connect = "172.81.250.30:2181";
        ZooKeeper zookeeper = null;
        CountDownLatch cdl = new CountDownLatch(0);
        String nodePath = "/yinjiaqi";
        String nodeChildPath = "/yinjiaqi/n1";
        try {
            zookeeper = new ZooKeeper(connect, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if(watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                      System.out.println("zookeeper已连接["+connect+"]成功");
                      cdl.countDown();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        cdl.await();
        System.out.println("zookpeer"+zookeeper);
    }


    @Test
    void testzkLock() throws InterruptedException {

    }

}
