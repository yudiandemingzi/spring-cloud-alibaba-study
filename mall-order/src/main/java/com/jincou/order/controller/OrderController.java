package com.jincou.order.controller;

import com.jincou.common.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 商品订单信息
 *
 * @author xub
 * @date 2021/3/30 下午3:38
 */
@RestController
@RequestMapping("api/v1/goods_order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getGoods")
    public Object save(int goodsId) {
        Goods goods = restTemplate.getForObject("http://localhost:6001/api/v1/goods/findByGoodsId?goodsId=" + goodsId, Goods.class);
        return goods;

    }

}
