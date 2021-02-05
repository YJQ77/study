package com.example.bloomfilter;

import com.example.bloomfilter.config.BloomFilterService;
import com.example.bloomfilter.entity.User;
import com.example.bloomfilter.service.AopTest2;
import com.example.bloomfilter.util.ApplicationContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BloomfilterApplicationTests {

//    @Autowired
//    private AopTest aopTest;

    @Test
    void testBloomFilter() {
        BloomFilterService bloomInit = ApplicationContextUtil.getBean("bloomService",BloomFilterService.class);
        User u = null;
        u =  new User(55,"yin55");
        System.out.println(bloomInit.userIdExists(u));
        u = new User(101,"yin101");
        System.out.println(bloomInit.userIdExists(u));
    }

    @Test
    void testAop() {
        AopTest2 aopTest = ApplicationContextUtil.getBean("aopTestImpl2", AopTest2.class);
        aopTest.getCount();
    }

}
