package com.jincou.goods.service;

import com.jincou.common.domain.Goods;

/**
 *  商品相关实现类
 *
 * @author xub
 * @date 2021/3/30 下午3:32
 */
public interface GoodsService {

    /**
     * 获取商品信息
     */
    Goods findById(int goodsId);
}
