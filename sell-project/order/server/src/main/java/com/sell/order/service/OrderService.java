package com.sell.order.service;

import com.sell.order.dto.OrderDTO;

/**
 * Created by Administratoron 2019/3/2
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
