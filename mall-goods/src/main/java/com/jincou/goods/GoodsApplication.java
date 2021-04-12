package com.jincou.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 *  商品服务启动类
 *
 * @author xub
 * @date 2021/3/30 下午3:35
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.jincou.goods.dao")
public class GoodsApplication {

    public static void main(String [] args){
        SpringApplication.run(GoodsApplication.class,args);
    }

}
