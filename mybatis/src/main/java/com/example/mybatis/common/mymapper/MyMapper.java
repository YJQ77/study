package com.example.mybatis.common.mymapper;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Author: YinJiaqi
 * Date: 11/11/2020 10:31 AM
 * Content:
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
