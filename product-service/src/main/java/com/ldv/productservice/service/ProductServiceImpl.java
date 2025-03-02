package com.ldv.productservice.service;

import com.ldv.productservice.adapter.ProductAdapter;
import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductAdapter productAdapter;

    public ProductServiceImpl(final ProductRepository productRepository, final ProductAdapter productAdapter) {
        this.productRepository = productRepository;
        this.productAdapter = productAdapter;
    }

    @Override
    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        return productAdapter.toProductDto(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found.")));
    }
}
