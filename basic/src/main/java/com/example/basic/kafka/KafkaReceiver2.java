package com.example.basic.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Author: YinJiaqi
 * Date: 4/20/2020 2:13 PM
 * Content:
 */
@Component
public class KafkaReceiver2 {
    private static Logger logger = LoggerFactory.getLogger(KafkaReceiver2.class);

    @KafkaListener(topics = {"hello"},groupId = "test-hello-group2")
    public void listen(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("consumer2  record =" + record);
            logger.info("consumer2消费了"+topic+"的message=" + message);
            ack.acknowledge();
        }

    }
}
