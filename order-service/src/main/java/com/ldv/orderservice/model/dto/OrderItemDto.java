package com.ldv.orderservice.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal priceAtOrder;
}
