package com.ldv.productservice.controller;

import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.model.dto.ProductStockUpdateDto;
import com.ldv.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-service/v1/products")
@Validated
public class ProductController {

    private ProductService productService;

    @Value("${product-service.customProperty:Default Value}")
    private String customProperty;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/by-ids")
    public ResponseEntity<List<ProductDto>> getProductsByIds(@RequestParam List<Long> productIds) {
        List<ProductDto> products = productService.getProductsByIds(productIds);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/stock")
    public ResponseEntity<Void> updateProductStock(@RequestBody List<@Valid ProductStockUpdateDto> stockUpdateDtos) throws ProductNotFoundException {
        productService.updateProductStock(stockUpdateDtos);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto productDto) {
        ProductDto createdProduct = productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }


}
