package com.example.mybatis;

import com.example.mybatis.entity.CourseFeedbackEntity;
import com.example.mybatis.mapper.CourseFeedbackEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 11/23/2020 2:42 PM
 * Content:
 */
@Slf4j
@RestController
@RequestMapping(value = "mybatis")
public class controller {

    @Autowired
    private CourseFeedbackEntityMapper courseFeedbackEntityMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CourseFeedbackEntity> list(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println(token);
        List<CourseFeedbackEntity> list = null;
        try {
            list = courseFeedbackEntityMapper.selectByLevel(Arrays.asList(1));
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        } catch (Exception e) {
            System.out.println("数据库扛不住了！");
        }
        return list;
    }
}
