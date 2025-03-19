package com.ldv.orderservice.client;

import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ProductProxyConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ProductProxyErrorDecoder();
    }

    @Bean
    public Retryer feignRetryer(@Value("${productProxy.retryCount}") int retryCount,
                                @Value("${productProxy.retryPeriod}") int retryPeriod,
                                @Value("${productProxy.maxRetryPeriod}") int maxRetryPeriod) {
        return new Retryer.Default(
                retryPeriod,
                maxRetryPeriod,
                retryCount
        );
    }
}
