package com.ldv.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-service/v1/products")
public class ProductController {

    @GetMapping
    public void getAllOrders() {
        //TODO
    }

    @GetMapping(path = "/{productId}")
    public void getOrderById(@PathVariable Long productId) {
        //TODO
    }

}
