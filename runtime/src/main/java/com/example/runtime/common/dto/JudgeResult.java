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
public class JudgeResult {
    //提交id
    private Integer submitId;
    //状态
    private Integer status;
    //时间消耗
    private Integer timeUsed;
    //内存消耗
    private Integer memoryUsed;
    //错误信息
    private String errorMessage;

}
