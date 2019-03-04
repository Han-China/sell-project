package com.sell.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Administratoron 2019/2/24
 **/
@Data
public class ProductVO {

    /** 类目名 **/
    /**
     * 用于当json中的key与对象中的字段名不一致时可以使用@JsonProperty注解进行标注
     */
    @JsonProperty("name")
    private String categoryName;

    /** 类目类型 **/
    @JsonProperty("type")
    private Integer categoryType;

    /** 商品列表 **/
    private List<ProductInfoVO> foods;
}
