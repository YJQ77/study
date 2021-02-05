package com.example.runtime.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 10:22 AM
 * Content:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Stdout {
    //状态
    private Integer status;
    //消耗内存
    private Long max_memory;
    //消耗时间
    private Long max_time;
}
