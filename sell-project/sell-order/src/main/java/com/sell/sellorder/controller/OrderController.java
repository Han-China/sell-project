package com.sell.sellorder.controller;

import com.sell.sellorder.converter.OrderForm2OrderDTOConverter;
import com.sell.sellorder.dto.OrderDTO;
import com.sell.sellorder.enums.OrderExceptionEnum;
import com.sell.sellorder.exception.OrderException;
import com.sell.sellorder.form.OrderForm;
import com.sell.sellorder.service.OrderService;
import com.sell.sellorder.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administratoron 2019/3/2
 **/
@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/create")
    public ResultVO create(@Validated OrderForm orderForm, BindingResult bindingResult) {

        // 如果参数校验失败，就抛出参数不正确的异常
        if(bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(OrderExceptionEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.conver(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(OrderExceptionEnum.CART_EMPTY);
        }

        orderDTO = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderDTO.getOrderId());

        return ResultVO.success(map);
    }
}
