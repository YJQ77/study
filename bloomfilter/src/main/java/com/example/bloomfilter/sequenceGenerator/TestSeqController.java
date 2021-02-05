package com.example.bloomfilter.sequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: YinJiaqi
 * Date: 11/26/2020 1:06 PM
 * Content:
 */
@RestController
public class TestSeqController {

    @Autowired
    private IDGenerator idGenerator;
    @RequestMapping(value = "/getSeq")
    public String getSeqNo(){
        Long masterNo = idGenerator.getId("masterNo");
        return idGenerator.lpad(11,masterNo);
    }
}
