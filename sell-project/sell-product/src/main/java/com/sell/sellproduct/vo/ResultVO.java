package com.sell.sellproduct.vo;

import lombok.Data;

/**
 * http请求返回的封装对象
 * Created by Administratoron 2019/2/24
 **/
@Data
public class ResultVO<T> {

    /** 错误码，0表示成功，其余表示失败 **/
    private Integer code;

    /** 提示信息 **/
    private String msg;

    /** 数据 **/
    private T data;
}
