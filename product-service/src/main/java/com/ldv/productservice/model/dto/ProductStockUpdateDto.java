package com.ldv.productservice.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductStockUpdateDto {

    @NotNull(message = "Product ID is required.")
    private Long productId;

    @Range(min = -1000, max = 1000, message = "Quantity change must be between -1000 and 1000.")
    private int quantityChange; // Can be positive (restock) or negative (purchase)
}