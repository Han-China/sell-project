package com.sell.order.entity;

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
@Table(name = "order_master")
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
public class OrderMaster implements Serializable {

    // 订单ID
    @Id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态, 默认为新下单
    private Integer orderStatus;

    //支付状态, 默认未支付
    private Integer payStatus;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
