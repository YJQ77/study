package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName(value = "course_feedback")
public class CourseFeedbackEntity {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;

    private Integer level;

    private String content;

    private String evaluation;

}