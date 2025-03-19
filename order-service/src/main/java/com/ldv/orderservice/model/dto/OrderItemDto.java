package com.ldv.orderservice.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long id;

    @NotNull(message = "Product ID is required.")
    private Long productId;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be at least 1.")
    private int quantity;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero.")
    private BigDecimal priceAtOrder;
}
