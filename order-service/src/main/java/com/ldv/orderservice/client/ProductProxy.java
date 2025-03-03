package com.ldv.orderservice.client;

import com.ldv.orderservice.model.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product", url = "localhost:8081")
public interface ProductProxy {

    @GetMapping("/api/product-service/v1/products/{productId}")
    ProductDto getProductById(@PathVariable("productId") Long productId);

    @GetMapping("/api/product-service/v1/products")
    List<ProductDto> getProductsByIds(@RequestParam List<Long> productIds);
}
