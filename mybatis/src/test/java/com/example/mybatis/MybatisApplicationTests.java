package com.example.mybatis;

import com.example.mybatis.entity.CourseFeedbackEntity;
import com.example.mybatis.mapper.CourseFeedbackEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Resource
    private CourseFeedbackEntityMapper courseFeedbackEntityMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void dataSource() {
        List<CourseFeedbackEntity> courseFeedbackEntities = courseFeedbackEntityMapper.selectByLevel(Arrays.asList(1,2,3,4,5,6));
    }
}
