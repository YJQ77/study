package com.example.basic.util; /**
 * Copyright 2020 bejson.com
 */

import com.example.basic.Charpters;

import java.util.List;

/**
 * Auto-generated: 2020-09-29 18:7:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JavaBean {

    private String name;
    private String whichOne;
    private List<Charpters> charpters;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setWhich_one(String whichOne) {
        this.whichOne = whichOne;
    }
    public String getWhichOne() {
        return whichOne;
    }

    public void setCharpters(List<Charpters> charpters) {
        this.charpters = charpters;
    }
    public List<Charpters> getCharpters() {
        return charpters;
    }

}