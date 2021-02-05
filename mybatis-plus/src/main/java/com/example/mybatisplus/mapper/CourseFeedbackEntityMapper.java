package com.example.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.entity.CourseFeedbackEntity;

import java.util.List;

public interface CourseFeedbackEntityMapper extends BaseMapper<CourseFeedbackEntity> {
    List<CourseFeedbackEntity> selectAll();
}