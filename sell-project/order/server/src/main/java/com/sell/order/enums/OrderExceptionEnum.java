package com.sell.order.enums;

import lombok.Getter;

/**
 * Created by Administratoron 2019/3/2
 **/
@Getter
public enum OrderExceptionEnum {

    PARAM_ERROR(1, "订单参数错误"),

    CART_JSON_CONVER_ORDERDETAIL_LIST_ERROR(2, "订单参数中的购物车json数据转换成订单详情列表出错"),

    CART_EMPTY(3, "购物车为空错误"),

    ;

    private Integer code;

    private String msg;

    OrderExceptionEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}
