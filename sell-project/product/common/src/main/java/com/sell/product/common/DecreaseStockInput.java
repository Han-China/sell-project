package com.sell.product.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 供减库存业务调用的数据传输对象，供服务间使用
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DecreaseStockInput {

    /** 商品ID **/
    private String productId;

    /** 购买商品的数量 **/
    private Integer productQuantity;
}