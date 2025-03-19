package com.ldv.orderservice.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private Long id;

    @NotNull(message = "Customer ID is required.")
    private Long customerId;

    @NotNull(message = "Order items are required.")
    @Size(min = 1, message = "At least one order item must be present.")
    private List<@Valid OrderItemDto> items;

    @NotNull(message = "Total price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total price must be greater than zero.")
    private BigDecimal totalPrice;
}
