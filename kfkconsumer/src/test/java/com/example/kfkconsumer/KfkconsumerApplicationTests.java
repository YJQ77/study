package com.example.kfkconsumer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
class KfkconsumerApplicationTests {
    private CountDownLatch countDownLatch = new CountDownLatch(1000);
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    @Test
    void contextLoads() {
    }

    @Test
    void testMybatis() {
        for (int i = 0; i < 10000; i++) {
            countDownLatch.countDown();
            Thread thread = new Thread(new testThread(countDownLatch, "a" + i));
            thread.start();
        }
    }

    class testThread implements Runnable {
        private CountDownLatch countDownLatch;
        private String name;

        public testThread(CountDownLatch countDownLatch, String name) {
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
                HttpUriRequest uriRequest = new HttpGet("http://localhost:8080/mybatis/list");
                uriRequest.addHeader("token","biabcdiad");
                HttpResponse response = httpClient.execute(uriRequest);
                System.out.println(name + "返回：" + EntityUtils.toString(response.getEntity()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
