package com.example.basic.dto;

import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 12/28/2020 12:00 PM
 * Content:
 */
@Data
public class ImageGalleryDto {
    private String code;
    private String channel;
    private String resolution;
    private  String container;
    private Integer sequence;
    private String urlEn;
    private String urlZh;
}
