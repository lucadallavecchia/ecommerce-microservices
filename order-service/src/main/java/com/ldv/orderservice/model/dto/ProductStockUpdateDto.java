package com.ldv.orderservice.model.dto;

import lombok.Data;

@Data
public class ProductStockUpdateDto {
    private Long productId;
    private int quantityChange; // Can be positive (restock) or negative (purchase)

    public ProductStockUpdateDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantityChange = quantity;
    }
}