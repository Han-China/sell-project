package com.sell.sellorder.service;

import com.sell.sellorder.dto.OrderDTO;

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
