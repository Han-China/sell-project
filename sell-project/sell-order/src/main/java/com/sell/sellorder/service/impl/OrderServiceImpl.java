package com.sell.sellorder.service.impl;

import com.sell.sellorder.client.ProductClient;
import com.sell.sellorder.dto.CartDTO;
import com.sell.sellorder.dto.OrderDTO;
import com.sell.sellorder.entity.OrderDetail;
import com.sell.sellorder.entity.OrderMaster;
import com.sell.sellorder.entity.ProductInfo;
import com.sell.sellorder.enums.OrderStatusEnum;
import com.sell.sellorder.enums.PayStatusEnum;
import com.sell.sellorder.repository.OrderDetailRepository;
import com.sell.sellorder.repository.OrderMasterRepository;
import com.sell.sellorder.service.OrderService;
import com.sell.sellorder.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administratoron 2019/3/2
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        // 1、查询商品信息(调用商品服务)
        List<String>  productIdList = orderDTO.getOrderDetailList()
                .stream()
                .map(orderDetail -> orderDetail.getProductId())
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);

        // 2、计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getProductId().equals(orderDetail.getProductId())) {
                    // 计算总金额，总金额 = 单价 * 数量
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);

                    OrderDetail orderDetailMe = new OrderDetail();
                    BeanUtils.copyProperties(productInfo, orderDetailMe);
                    orderDetailMe.setProductQuantity(orderDetail.getProductQuantity());
                    orderDetailMe.setDetailId(KeyUtil.genUniqueKey());
                    orderDetailMe.setOrderId(orderId);
                    orderDetailMe.setCreateTime(null);
                    orderDetailMe.setUpdateTime(null);

                    // 将orderDetailMe放入到List中，最后一次性的save到数据库，减少数据库的连接次数
                    orderDetailList.add(orderDetailMe);
                }
            }
        }

        // 3、扣库存(调用商品服务)
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                .stream()
                .map(e -> (new CartDTO()).setProductId(e.getProductId()).setProductQuantity(e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 4、订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        orderDTO.setOrderId(orderId);

        // 5、订单详情入库
        orderDetailRepository.saveAll(orderDetailList);

        return orderDTO;
    }
}
