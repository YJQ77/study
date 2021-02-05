package com.example.basic.kafka;


import com.example.basic.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Author: YinJiaqi
 * Date: 4/20/2020 2:10 PM
 * Content:
 */
@Component
public class KfkaProducer {
    private static Logger logger = LoggerFactory.getLogger(KfkaProducer.class);
    @Autowired
    private KafkaUtil kafkaUtil;


    //发送消息方法
    public void send() {
        for(int i=0;i<5;i++){
            Message message = new Message();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString()+ "---" +i);
            message.setSendTime(new Date());
            kafkaUtil.sendMessage("shuaige",message);

        }
    }
}
