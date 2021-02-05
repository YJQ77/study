package com.example.basic.webSocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: YinJiaqi
 * Date: 4/26/2020 3:47 PM
 * Content:
 */
@Slf4j
@Controller
public class indexController {
    @RequestMapping("/websocket/{name}")
    public ModelAndView webSocket(@PathVariable String name){
        ModelAndView mav = new ModelAndView();
            mav.addObject("username",name);
            mav.setViewName("index");
            return mav;
    }
}
