package com.example.kfkproducer.producer;


import com.example.kfkproducer.entity.Message;
import com.example.kfkproducer.util.KafkaUtil;
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
            message.setMsg(UUID.randomUUID().toString()+ "---student" +i);
            message.setSendTime(new Date());
            kafkaUtil.sendMessage("shuaige","studentInfo",message);
        }

        for(int i=0;i<5;i++){
            Message message = new Message();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString()+ "---homework" +i);
            message.setSendTime(new Date());
            kafkaUtil.sendMessage("shuaige","homeworkInfo",message);
        }
    }
}
