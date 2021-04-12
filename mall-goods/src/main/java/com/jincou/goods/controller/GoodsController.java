package com.jincou.goods.controller;

import com.jincou.common.domain.Goods;
import com.jincou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 商品相关接口
 *
 * @author xub
 * @date 2021/3/30 下午3:31
 */
@RestController
@RequestMapping("api/v1/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("findByGoodsId")
    public Object findByGoodsId(int goodsId) {
        Goods goods = goodsService.findById(goodsId);
        return goods;
    }

}
