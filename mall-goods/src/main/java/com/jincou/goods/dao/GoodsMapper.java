package com.jincou.goods.dao;

import com.jincou.common.domain.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *  查询商品信息
 *
 * @author xub
 * @date 2021/3/30 下午3:28
 */
@Repository
public interface GoodsMapper {

    @Select("select * from goods where id=#{goodsId}")
    Goods findById(@Param("goodsId") int goodsId);

}
