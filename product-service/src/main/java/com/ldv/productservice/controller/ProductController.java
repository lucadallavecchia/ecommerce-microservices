package com.ldv.productservice.controller;

import com.ldv.productservice.dto.ProductDto;
import com.ldv.productservice.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/product-service/v1/products")
public class ProductController {

    @GetMapping
    public void getAllProducts() {
        //TODO
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        ProductDto productDto = new ProductDto();
        productDto.setId(productId);
        productDto.setName("Shower Filter");
        productDto.setPrice(new BigDecimal("2"));
        productDto.setStock(25);

        return ResponseEntity.ok(productDto);

        //TODO add the throw error logic
        //throw new ProductNotFoundException(productId);
    }

}
