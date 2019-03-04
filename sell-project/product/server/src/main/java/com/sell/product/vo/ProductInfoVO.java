package com.sell.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administratoron 2019/2/24
 **/
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private  String productId;

    /** 商品名称 **/
    @JsonProperty("name")
    private  String productName;

    /** 单价 **/
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 描述 **/
    @JsonProperty("description")
    private  String productDescription;

    /** 小图 **/
    @JsonProperty("icon")
    private  String productIcon;
}
