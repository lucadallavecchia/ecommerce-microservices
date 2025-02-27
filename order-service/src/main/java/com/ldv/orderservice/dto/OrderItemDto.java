package com.ldv.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal priceAtOrder;
}
