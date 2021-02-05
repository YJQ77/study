package com.example.basic.dto;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 12/28/2020 11:55 AM
 * Content:
 */
@Data
public class LableDto {
    private String code;
    private String name;
    private String nameEn;
    private Integer type;
    //是否禁用（0:未禁用；1:已禁用）
    private Integer isDisabled;
    private String createdTime;
    private String updatedTime;
}
