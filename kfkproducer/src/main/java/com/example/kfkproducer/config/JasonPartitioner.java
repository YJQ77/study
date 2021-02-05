package com.example.kfkproducer.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Author: YinJiaqi
 * Date: 8/6/2020 4:12 PM
 * Content:
 */
public class JasonPartitioner<T> implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int partitionNum = 0;
        if (key == null) {
            partitionNum = new Random().nextInt(partitions.size());
        } else {
            if("studentInfo".equalsIgnoreCase(key.toString())){
                partitionNum = 4;
            }else if("homeworkInfo".equalsIgnoreCase(key.toString())){
                partitionNum = 3;
            }
        }
        System.out.println("key：" + key + "，value：" + value + "，partitionNum：" + partitionNum);
        //发送到指定分区
        return partitionNum;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
