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
public class JudgeTask {
    private String appName;

    private int submitId;

    private int compilerId;

    private int problemId;

    private String source;

    private int timeLimit;

    private int memoryLimit;

    private boolean isSpecial;

}
