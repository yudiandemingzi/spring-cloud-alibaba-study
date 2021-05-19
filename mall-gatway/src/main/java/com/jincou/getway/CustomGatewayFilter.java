package com.jincou.getway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 */
@Component
public class CustomGatewayFilter implements GlobalFilter, Ordered {
    private Logger log = LogManager.getLogger(CustomGatewayFilter.class);
    /**
     * 过滤器业务逻辑
     *
     * @param exchange
     * @param chain
     * @return
     */
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       log.info("打印请求日志:{}",exchange.getRequest().getURI().getRawPath());
        // 继续向下执行
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行顺序，数值越小，优先级越高
     *
     * @return
     */
    public int getOrder() {
        return 0;
    }
}