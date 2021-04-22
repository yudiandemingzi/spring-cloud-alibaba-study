package com.jincou.order.service;

import com.jincou.common.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * mall-good s就是商品微服务的 spring.application.name
 */
@FeignClient(value = "mall-goods")
public interface GoodsService {

    /**
     * /api/v1/goods/findByGoodsId就是商品服务提供的接口，参数也是
     */
    @GetMapping("/api/v1/goods/findByGoodsId")
    Goods findById(@RequestParam("goodsId") int goodsId);

    /**
     * /api/v1/goods/findByGoodsId就是商品服务提供的接口，参数也是
     */
    @GetMapping("/api/v1/goods/findClusterName")
    String findClusterName();
}
