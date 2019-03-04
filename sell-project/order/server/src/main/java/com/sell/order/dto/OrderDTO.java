package com.sell.order.dto;

import com.sell.order.entity.OrderDetail;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单的数据传输对象(DTO)
 * Created by Administratoron 2019/3/2
 **/
@Data
@Accessors(chain = true)
public class OrderDTO {

    // 订单ID
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

    // 订单详情列表
    private List<OrderDetail> orderDetailList;
}
