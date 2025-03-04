package com.ldv.orderservice.client;

import com.ldv.orderservice.model.dto.ProductDto;
import com.ldv.orderservice.model.dto.ProductStockUpdateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product", url = "localhost:8081")
public interface ProductProxy {

    @GetMapping("/api/product-service/v1/products/by-ids")
    List<ProductDto> getProductsByIds(@RequestParam List<Long> productIds);

    @PutMapping("/api/product-service/v1/products/stock")
    public ResponseEntity<Void> updateProductStock(@RequestBody List<ProductStockUpdateDto> stockUpdateDtos);
}
