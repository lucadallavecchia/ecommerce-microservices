package com.ldv.productservice.controller;

import com.ldv.productservice.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-service/v1/products")
public class ProductController {

    @GetMapping
    public void getAllProducts() {
        //TODO
    }

    @GetMapping(path = "/{productId}")
    public void getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        throw new ProductNotFoundException(productId);
    }

}
