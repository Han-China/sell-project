package com.sell.sellproduct.enums;

import lombok.Getter;

/**
 * 商品异常枚举
 * Created by Administratoron 2019/3/2
 **/
@Getter
public enum ProductExceptionEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),

    PRODUCT_STOCK_SHORT(2, "商品库存不足"),

    ;

    private Integer code;

    private String message;

    ProductExceptionEnum(Integer code, String message) {

        this.code = code;
        this.message = message;
    }
}
