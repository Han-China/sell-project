package com.sell.order.exception;

import com.sell.order.enums.OrderExceptionEnum;

/**
 * Created by Administratoron 2019/3/2
 **/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {

        super(message);
        this.code = code;
    }

    public OrderException(OrderExceptionEnum orderException) {

        super(orderException.getMsg());
        this.code = orderException.getCode();
    }
}
