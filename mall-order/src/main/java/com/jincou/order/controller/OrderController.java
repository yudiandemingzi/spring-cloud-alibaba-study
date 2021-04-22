package com.jincou.order.controller;

import com.jincou.common.domain.Goods;
import com.jincou.order.service.GoodsService;
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

    @Autowired
    private  GoodsService goodsService;

    /**
     * 通过RestTemplate请求mall-goods服务
     */
    @RequestMapping("getGoods")
    public Object save(int goodsId) {
        Goods goods = restTemplate.getForObject("http://localhost:6001/api/v1/goods/findByGoodsId?goodsId=" + goodsId, Goods.class);
        return goods;
    }

    /**
     * 通过Feign请求mall-goods服务
     */
    @RequestMapping("getGoodsByFeign")
    public Object getGoodsByFeign(int goodsId) {
        Goods goods = goodsService.findById(goodsId);
        return goods;
    }

    /**
     * 通过Feign请求mall-goods服务
     */
    @RequestMapping("getClusterName")
    public Object findClusterName() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(goodsService.findClusterName());
        }
        return "执行结束";
    }

}
