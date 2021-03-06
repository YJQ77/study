package com.example.kfkproducer.util;

import com.example.kfkproducer.config.JasonPartitioner;
import com.example.kfkproducer.producer.KfkaProducer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.Partitioner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * Author: YinJiaqi
 * Date: 9/18/2020 4:06 PM
 * Content:
 */
@Component
public class KafkaUtil {
    private static Logger logger = LoggerFactory.getLogger(KfkaProducer.class);
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    //生产消息
    public <T> void sendMessage(String topic, String key, T t) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, gson.toJson(t));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("发送消息失败 ----->>>>>  message = {}", throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("发送消息 ----->>>>>  message = {}", "partition" + result.getRecordMetadata().partition() + gson.toJson(t));
            }
        });
    }
}
