package com.ldv.productservice.service;

import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.model.mapper.ProductMapper;
import com.ldv.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(final ProductRepository productRepository, final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        return productMapper.productToProductDto(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found.")));
    }

    @Override
    public List<ProductDto> getProductsByIds(List<Long> productIds) {
        return productMapper.productsToProductDtos(productRepository.findAllById(productIds));
    }
}
