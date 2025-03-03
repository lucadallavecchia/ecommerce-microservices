package com.ldv.productservice.model.dto;

import lombok.Data;

@Data
public class ProductStockUpdateDto {
    private Long productId;
    private int quantityChange; // Can be positive (restock) or negative (purchase)
}