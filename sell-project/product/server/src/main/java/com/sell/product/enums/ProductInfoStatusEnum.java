package com.sell.product.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 * Created by Administratoron 2019/2/24
 **/
@Getter
public enum ProductInfoStatusEnum {

    UP(0, "上架"),

    DOWN(1, "下架")

    ;

    private Integer code;

    private String message;

    ProductInfoStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
