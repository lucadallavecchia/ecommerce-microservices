package com.ldv.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private Long customerId;
    private List<OrderItemDto> items;
    private BigDecimal totalPrice;
}
