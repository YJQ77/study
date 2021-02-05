package com.example.mybatisplus.controller;

import com.example.mybatisplus.entity.CourseFeedbackEntity;
import com.example.mybatisplus.mapper.CourseFeedbackEntityMapper;
import com.example.mybatisplus.service.CourseFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: YinJiaqi
 * Date: 1/12/2021 3:07 PM
 * Content:
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private CourseFeedbackEntityMapper courseFeedbackEntityMapper;
    @Autowired
    private CourseFeedbackService courseFeedbackService;

    @RequestMapping(value = "/insert")
    public Object test(){
        courseFeedbackService.test();
        return "success";
    }
}
