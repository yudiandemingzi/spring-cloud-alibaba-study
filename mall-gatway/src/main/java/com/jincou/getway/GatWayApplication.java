package com.jincou.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 *  网管启动类
 *
 * @author xub
 * @date 2021/3/30 下午3:35
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatWayApplication {

    public static void main(String [] args){
        SpringApplication.run(GatWayApplication.class,args);
    }

}
