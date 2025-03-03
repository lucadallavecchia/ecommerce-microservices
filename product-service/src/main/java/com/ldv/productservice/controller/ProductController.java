package com.ldv.productservice.controller;

import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-service/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductsByIds(@RequestParam List<Long> productIds) {
        List<ProductDto> products = productService.getProductsByIds(productIds);
        return ResponseEntity.ok(products);
    }

}
