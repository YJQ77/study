package com.example.mybatis.config.dataSourceConfig;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: YinJiaqi
 * Date: 11/11/2020 1:48 PM
 * Content:
 */
@Configuration
public class DynamicDataSourceConfig {
    @Bean
    @ConfigurationProperties(value = "spring.datasource.druid.one")
    DataSource one(){return DruidDataSourceBuilder.create().build(); }

    @Bean
    @ConfigurationProperties(value = "spring.datasource.druid.two")
    DataSource two(){return DruidDataSourceBuilder.create().build(); }

    @Bean
    @Primary
    DynamicDataSource dataSource(DataSource one,DataSource two){
        Map<Object,Object> map = new HashMap<>();
        map.put("one",one);
        map.put("two",two);
        return new DynamicDataSource(one,map);
    }
}
