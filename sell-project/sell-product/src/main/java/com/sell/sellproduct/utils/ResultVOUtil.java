package com.sell.sellproduct.utils;

import com.sell.sellproduct.vo.ResultVO;

/**
 * Created by Administratoron 2019/2/25
 **/
public class ResultVOUtil {

    public static ResultVO success(Object data) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);

        return resultVO;
    }
}
