package com.example.mybatis.mapper;

import com.example.mybatis.entity.CourseFeedbackEntity;
import java.util.List;

public interface CourseFeedbackEntityMapper {
    List<CourseFeedbackEntity> selectAll();
}