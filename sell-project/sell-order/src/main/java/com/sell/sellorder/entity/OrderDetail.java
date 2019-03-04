package com.sell.sellorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administratoron 2019/2/25
 **/
@Table(name = "order_detail")
@Entity
// 提供全参的构造方法
@AllArgsConstructor
// 提供无参的构造方法
@NoArgsConstructor
// 提供get、set方法
@Data
// 提供链式风格的方法调用
@Accessors(chain = true)
// 提供toString方法
@ToString
public class OrderDetail implements Serializable {

    // 订单详情ID
    @Id
    private String detailId;

    // 订单ID
    private String orderId;

    // 商品ID
    private String productId;

    //商品名称
    private String productName;

    //当前价格,单位分
    private BigDecimal productPrice;

    //数量
    private Integer productQuantity;

    //小图
    private String productIcon;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
