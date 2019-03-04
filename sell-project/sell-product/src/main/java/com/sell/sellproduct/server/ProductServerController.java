package com.sell.sellproduct.server;

import com.sell.sellproduct.dto.CartDTO;
import com.sell.sellproduct.entity.ProductInfo;
import com.sell.sellproduct.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品服务控制器，供其他服务调用
 * Created by Administratoron 2019/3/2
 **/
@RestController
@RequestMapping(value = "/server/product")
@Slf4j
public class ProductServerController {

    @Value("${server.port}")
    private String port;
    
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 供其他服务测试使用
     * @return
     */
    @GetMapping(value = "/msg")
    public String msg() {

        String msg = "this is product server, port=" + port;
        log.info(msg);

        return msg;
    }

    /**
     * 查询订单中的所有商品详情，供订单服务调用
     * @param productIdList：商品id集合
     * @return
     */
    @GetMapping(value = "/listForOrder")
    public List<ProductInfo> listForOrder(@RequestParam("productIdList") List<String> productIdList) {

        return productInfoService.findList(productIdList);
    }

    /**
     * 扣库存
     * @param cartDTOList：订单中的商品列表
     */
    @PostMapping(value = "/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {

        productInfoService.decreaseStock(cartDTOList);
    }
}
