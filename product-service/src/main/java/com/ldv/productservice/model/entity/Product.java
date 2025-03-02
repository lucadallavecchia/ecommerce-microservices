package com.ldv.productservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private int stock; //quantity available of the product

    public void decreaseStock(int quantity) {
        if (this.stock >= quantity) {
            this.stock -= quantity;
        } else {
            throw new IllegalStateException("Insufficient stock for the product: " + this.name);
        }
    }
}
