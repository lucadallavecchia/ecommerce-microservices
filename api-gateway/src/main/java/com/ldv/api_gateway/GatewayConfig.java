package com.ldv.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/api/order-service/**")
                        .uri("lb://order-service"))  // Inoltra il path completo
                .route("product-service", r -> r.path("/api/product-service/**")
                        .uri("lb://product-service"))  // Inoltra il path completo
                .build();
    }
}
