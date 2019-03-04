package com.sell.sellorder.enums;

import lombok.Getter;

/**
 * Created by Administratoron 2019/2/25
 **/
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),

    FINISH(2, "完结"),

    CANCEL(3, "取消"),

    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
