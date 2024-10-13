package com.wolfisher.waterway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class WaterWayGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        log.info("Global Pre Filter executed");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("Global Post Filter executed")));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
