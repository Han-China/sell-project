package com.sell.sellorder.enums;

import lombok.Getter;

/**
 * Created by Administratoron 2019/2/25
 **/
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),

    SUCCESS(1, "支付成功"),

    FAIL(2, "支付失败"),

    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
