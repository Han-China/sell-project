package com.sell.sellorder.vo;

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

    public static ResultVO success(Object data) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);

        return resultVO;
    }

    public static ResultVO fail(String msg) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("失败");

        return resultVO;
    }
}
