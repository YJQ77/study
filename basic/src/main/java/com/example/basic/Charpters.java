package com.example.basic;

import java.util.List;

/**


/**
 * Auto-generated: 2020-09-29 17:56:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Charpters {

    private String charpterName;
    private List<Points> points;
    public void setCharpterName(String charpterName) {
        this.charpterName = charpterName;
    }
    public String getCharpterName() {
        return charpterName;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }
    public List<Points> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Charpters{" +
                "charpterName='" + charpterName + '\'' +
                ", points=" + points +
                '}';
    }
}