package com.example.basic.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 12/28/2020 11:20 AM
 * Content:
 */
@Data
public class ProductSKU {
    private String code;
    private String poskey;
    private String name;
    private String nameEn;
    private String mainImageUrl;
    private List<ImageGalleryDto> imageGallery;
    //上架状态（0:未上架；1:已上架）
    private Integer onlineStatus;
    //库存状态（0:已售罄；1:未售罄）
    private Integer stockStatus;
    //是否删除（0:未删除；1：已删除）
    private Integer isDeleted;
    private List<LableDto> lableList;
    private List<PriceDto> priceList;
    private List<Spec> specList;
    private String createdTime;
    private String updatedTime;
    @Data
    class PriceDto{
        private String pePriceId;
        //(DECIMAL(10,2))
        private BigDecimal price;
        private String startEffectiveTime;
        private String endEffectiveTime;
    }
    class Spec{
        private String specName;
        private String specNameEn;
        private Integer sequence;
        private String specValue;
        private String specValueEn;
    }
}
