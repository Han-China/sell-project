package com.sell.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administratoron 2019/2/24
 **/
@Entity
@Table(name = "product_info")
// 提供全参的构造方法
@AllArgsConstructor
// 提供无参的构造方法
@NoArgsConstructor
// 提供get、set方法
@Data
// 提供链式风格的方法调用
@Accessors(chain = true)
public class ProductInfo {

    @Id
    private String productId;

    //商品名称
    private String productName;

    //单价
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //小图
    private String productIcon;

    //商品状态,0正常1下架
    private Integer productStatus = 0;

    //类目编号
    private Integer categoryType;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

}
