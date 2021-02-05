//package com.example.kfkconsumer.consumer;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.PartitionOffset;
//import org.springframework.kafka.annotation.TopicPartition;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * Author: YinJiaqi
// * Date: 4/20/2020 2:13 PM
// * Content:
// */
//@Component
//public class KafkaReceiver {
//    private static Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);
//
//    @KafkaListener(groupId = "shuaige-group",topicPartitions = {@TopicPartition(topic = "shuaige",partitions = {"3"})},containerFactory = "kafkaListenerContainerFactory")
//    public void listen(List<ConsumerRecord<?, ?>> records, Acknowledgment ack , @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        for (ConsumerRecord<?, ?> record:records){
//            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//            if (kafkaMessage.isPresent()) {
//                Object message = kafkaMessage.get();
//                logger.info("consumer1 record =" + record);
//                logger.info("consumer1消费了"+topic+"的message=" + message);
//                ack.acknowledge();
//            }
//        }
//    }
//}
