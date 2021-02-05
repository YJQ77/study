package com.example.bloomfilter.config;

import com.example.bloomfilter.entity.User;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 11/18/2020 11:06 AM
 * Content:
 */
@Service(value = "bloomService")
public class BloomFilterService {
    private BloomFilter<Integer> bloomFilter;
    @PostConstruct
    public void initBloom() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(i,"yin"+i);
            list.add(user);
        }
        bloomFilter = BloomFilter.create(Funnels.integerFunnel(),list.size());
        for (User u : list){
            bloomFilter.put(u.getId());
        }
    }

    public boolean userIdExists(User user){
        return bloomFilter.mightContain(user.getId());
    }
}
