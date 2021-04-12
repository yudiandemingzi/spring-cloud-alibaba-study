package com.jincou.goods.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 商品相关接口
 *
 * @author xub
 * @date 2021/3/30 下午3:31
 */
@RestController
@RequestMapping("api/v1/config")
public class ConfigTestController {

    /**
     * nacos获取配置
     */
    @Value("${user.name}")
    private String name;

    @RequestMapping("test-config")
    public Object findByGoodsId() {
        System.out.println("name = " + name);
        return name;
    }

}
