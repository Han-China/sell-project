package com.sell.sellorder.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sell.sellorder.dto.OrderDTO;
import com.sell.sellorder.entity.OrderDetail;
import com.sell.sellorder.enums.OrderExceptionEnum;
import com.sell.sellorder.enums.OrderStatusEnum;
import com.sell.sellorder.exception.OrderException;
import com.sell.sellorder.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 将OrderForm对象转换成OrderDTO对象的转换器
 * Created by Administratoron 2019/3/2
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {

    /**
     * 将OrderForm对象转换成OrderDTO对象
     * @param orderForm
     * @return
     */
    public static OrderDTO conver(OrderForm orderForm) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(OrderExceptionEnum.CART_JSON_CONVER_ORDERDETAIL_LIST_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return  orderDTO;
    }
}
