package com.jincou.goods.controller;

import com.jincou.common.domain.Goods;
import com.jincou.goods.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


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

    private Logger log = LogManager.getLogger(GoodsController.class);

    @RequestMapping("findByGoodsId")
    public Object findByGoodsId(int goodsId, HttpServletRequest request) {
        Goods goods = goodsService.findById(goodsId);

        //打印是哪个节点被请求
        System.out.println("当前服务器名称: " + request.getServerName()+";当前集群节点端口号: "+ request.getServerPort());

        log.info("商品服务");
        return goods;
    }

    @RequestMapping("findClusterName")
    public Object findClusterName( HttpServletRequest request) {
        //获取是哪个节点被请求
        String clusterName = "当前服务器名称: " + request.getServerName()+";当前集群节点端口号: "+ request.getServerPort();
        return clusterName;
    }

}
