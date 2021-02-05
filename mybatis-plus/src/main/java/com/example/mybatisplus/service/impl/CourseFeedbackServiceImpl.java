package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.CourseFeedbackEntity;
import com.example.mybatisplus.mapper.CourseFeedbackEntityMapper;
import com.example.mybatisplus.service.CourseFeedbackService;
import org.springframework.stereotype.Service;

/**
 * Author: YinJiaqi
 * Date: 1/12/2021 3:47 PM
 * Content:
 */
@Service
public class CourseFeedbackServiceImpl extends ServiceImpl<CourseFeedbackEntityMapper, CourseFeedbackEntity>
        implements CourseFeedbackService {

    @Override
    public void test() {
        CourseFeedbackEntity entity = new CourseFeedbackEntity();
        entity.setId(1);
        entity.setLevel(111);
        entity.setContent("声音听不清,图像不清晰,视频卡顿,老师讲的不好,没听明白,其他");
        entity.setEvaluation("好");
        this.saveOrUpdate(entity);
    }
}
