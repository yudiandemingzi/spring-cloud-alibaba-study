package com.jincou.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 *  订单服务启动类
 *
 * @author xub
 * @date 2021/3/30 下午3:39
 */
//开启Feign支持
@EnableFeignClients
//开启服务发现
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {

    public static void main(String [] args){
        SpringApplication.run(OrderApplication.class,args);
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule loadBalancer(){
        return new RandomRule();
    }

}
