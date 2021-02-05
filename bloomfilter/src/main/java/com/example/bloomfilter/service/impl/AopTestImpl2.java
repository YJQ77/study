package com.example.bloomfilter.service.impl;

import com.example.bloomfilter.service.AopTest;
import com.example.bloomfilter.service.AopTest2;
import org.springframework.stereotype.Service;

/**
 * Author: YinJiaqi
 * Date: 12/1/2020 3:22 PM
 * Content:
 */
@Service
public class AopTestImpl2 implements AopTest2 {
    @Override
    public void test() {
        System.out.println("hello");
    }

    @Override
    public Integer getCount() {
        return 2;
    }
}
