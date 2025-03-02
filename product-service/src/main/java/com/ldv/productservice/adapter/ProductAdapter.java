package com.ldv.productservice.adapter;

import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.model.entity.Product;
import com.ldv.productservice.model.mapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter {

    private final ProductMapper productMapper;

    public ProductAdapter(final ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ProductDto toProductDto(Product product) {
        return productMapper.productToProductDto(product);
    }
}
