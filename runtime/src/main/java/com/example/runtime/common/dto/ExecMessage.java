package com.example.runtime.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: YinJiaqi
 * Date: 12/4/2020 10:13 AM
 * Content:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecMessage {
    private String error;

    private String stdout;
}
