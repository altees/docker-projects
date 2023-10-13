package com.altees.edgeservice.filters;

import com.altees.edgeservice.exception.AutheticationRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.function.Supplier;

@Component
public class ErrorHandlingPostFilter extends AbstractGatewayFilterFactory<ErrorHandlingPostFilter.Config> {
    final Logger logger =
            LoggerFactory.getLogger(
                    ErrorHandlingPostFilter.class);
    HashMap<Integer, Supplier<ResponseStatusException>> exceptionMap = new HashMap<>();


    public ErrorHandlingPostFilter() {
        super(Config.class);
        exceptionMap.put(401, () -> new AutheticationRequiredException("Authentication required"));
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                //post Filters - Logic to handle the response before forwarding it to the requester
                exceptionMap.computeIfPresent(exchange.getResponse().getStatusCode().value(), (key, supplier) -> {
                    throw supplier.get();
                });
            }));
        };
    }

    public static class Config {

    }
}
