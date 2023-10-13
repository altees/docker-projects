package com.altees.edgeservice.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class AuthenticationPreFilter extends AbstractGatewayFilterFactory<AuthenticationPreFilter.Config> {


    public AuthenticationPreFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();

            if (!CollectionUtils.isEmpty(headers.get("auth")) && "granted".equalsIgnoreCase(headers.get("auth").get(0)))
                return chain.filter(exchange);
            throw new RuntimeException("Authentication Required");
        };
    }

    public static class Config {

    }


}


