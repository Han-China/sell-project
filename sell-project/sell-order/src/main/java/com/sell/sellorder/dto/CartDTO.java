package com.sell.sellorder.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用于存储订单中的商品信息的数据传输对象(DTO)
 * Created by Administratoron 2019/3/2
 **/
@Data
@Accessors(chain = true)
public class CartDTO {

    /** 商品ID **/
    private String productId;

    /** 商品数量 **/
    private Integer productQuantity;
}
