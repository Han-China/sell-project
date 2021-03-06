package com.sell.product.client;

import com.sell.product.common.DecreaseStockInput;
import com.sell.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品客户端，用于从商品服务端获取商品信息，供其他服务调用
 * Created by Administratoron 2019/3/2
 **/
@FeignClient(value = "SELL-PRODUCT")
public interface ProductClient {

    /**
     * 测试方法，测试商品服务端是否可以连通
     * @return
     */
    @GetMapping(value = "/server/product/msg")
    String getMsg();

    /**
     * 查询订单中的所有商品详情，传递参数时必须在服务端和客户端都加上@RequestParam注解，不然参数传不过去
     * @RequestParam、@PathVariable对应的是get请求
     * @RequestBody对应的是post请求
     * @param productIdList：商品id集合
     * @return
     */
    @GetMapping(value = "/server/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestParam("productIdList") List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList：订单中的商品列表
     */
    @PostMapping(value = "/server/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);
}
