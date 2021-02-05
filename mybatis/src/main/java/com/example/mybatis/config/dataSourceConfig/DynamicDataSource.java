package com.example.mybatis.config.dataSourceConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Author: YinJiaqi
 * Date: 11/11/2020 2:04 PM
 * Content:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public DynamicDataSource(DataSource deflautDataSource, Map<Object,Object> map) {
        super.setDefaultTargetDataSource(deflautDataSource);
        super.setTargetDataSources(map);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String source = getSource();
        System.out.println(source);
        return source;
    }

    public  String getSource(){
        return threadLocal.get();
    }

    public static void setDataSource(String source){
        threadLocal.set(source);
    }

    public static void removeDataSource(){
        threadLocal.remove();
    }

}
