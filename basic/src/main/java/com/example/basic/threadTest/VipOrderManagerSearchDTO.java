package com.example.basic.threadTest;


import lombok.Data;

/**
 * Author: YinJiaqi
 * Date: 9/15/2020 1:33 PM
 * Content:
 */
@Data
public class VipOrderManagerSearchDTO  {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer subject;
    private Integer payType;
    private Integer isPay;
    private String orderNo;
    private String masterNo;
    private String macCode;
    private String money;

    @Override
    public String toString() {
        return "VipOrderManagerSearchDTO{" +
                "id=" + id +
                ", subject=" + subject +
                ", payType=" + payType +
                ", isPay=" + isPay +
                ", orderNo='" + orderNo + '\'' +
                ", masterNo='" + masterNo + '\'' +
                ", macCode='" + macCode + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
