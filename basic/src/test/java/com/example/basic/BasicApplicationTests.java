package com.example.basic;

//import com.yjq.study.kafka.KfkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@EnableAsync
@SpringBootTest
class StudyApplicationTests {

    //    @Autowired
//    private KfkaProducer kfkaProducer;;
    @Autowired
    private Main main;
    @Test
    void contextLoads() {
    }
    @Test
    public void KafkaProducer() throws InterruptedException {
        long l = System.currentTimeMillis();
        Future<String> task1 = main.TaskOne();
        Future<String> task2 = main.TaskTwo();
        Future<String> task3 = main.TaskThree();
        while(true){
            if(task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }
            Thread.sleep(1000);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
    }

}
