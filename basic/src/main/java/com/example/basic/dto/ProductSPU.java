package com.example.basic.dto;

import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * Author: YinJiaqi
 * Date: 12/28/2020 11:17 AM
 * Content:
 */
@Data
public class ProductSPU {
    private String code;
    private String name;
    private String nameEn;
    private String productType;
    private String mainImageUrl;
    private String unit;
    private List<ProductSKU> skuList;
    private List<Spec> specList;
    private List<LableDto> lableList;
    private List<Category> categoryList;
    private List<ImageGalleryDto> imageGallery;
    private String createdTime;
    private String updatedTime;
    @Data
    class Spec {
        private String specName;
        private String specNameEn;
        private Integer sequence;
        private List<SpecValue> specValueList;
        @Data
        class SpecValue{
            private String specValue;
            private String specValueEn;
            private Integer sequence;
        }
    }
    @Data
    class Category{
        private String code;
        private String name;
        private String nameEn;
        private Integer level;
        private Integer sequence;
        //是否被禁用（0:未禁用；1:已禁用）
        private Integer isDisabled;
        private List<ImageGalleryDto> ImageGallery;
        private String createdTime;
        private String updatedTime;
    }

}
