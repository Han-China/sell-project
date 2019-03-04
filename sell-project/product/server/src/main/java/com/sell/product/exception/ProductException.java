package com.sell.product.exception;

import com.sell.product.enums.ProductExceptionEnum;

/**
 * 与商品有关的异常
 * Created by Administratoron 2019/3/2
 **/
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {

        super(message);
        this.code = code;
    }

    public ProductException(ProductExceptionEnum productException) {

        super(productException.getMessage());
        this.code = productException.getCode();
    }
}
