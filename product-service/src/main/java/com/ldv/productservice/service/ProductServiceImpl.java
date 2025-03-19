package com.ldv.productservice.service;

import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.model.dto.ProductStockUpdateDto;
import com.ldv.productservice.model.entity.Product;
import com.ldv.productservice.model.mapper.ProductMapper;
import com.ldv.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(final ProductRepository productRepository, final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getProductsByIds(List<Long> productIds) {
        return productMapper.productsToProductDtos(productRepository.findAllById(productIds));
    }

    @Override
    @Transactional
    public void updateProductStock(List<ProductStockUpdateDto> stockUpdates) throws ProductNotFoundException {
        Map<Long, Product> productMap = productRepository.findAllById(stockUpdates.stream().map(ProductStockUpdateDto::getProductId).toList()).stream().collect(Collectors.toMap(Product::getId, product -> product));

        for (ProductStockUpdateDto stockUpdate : stockUpdates) {
            Product product = productMap.get(stockUpdate.getProductId());
            if (product == null) {
                throw new ProductNotFoundException("Product ID not found: " + stockUpdate.getProductId());
            }

            int newStock = product.getStock() + stockUpdate.getQuantityChange();
            if (newStock < 0) {
                throw new IllegalArgumentException("Insufficient stock for product ID: " + stockUpdate.getProductId());
            }

            product.setStock(newStock);
        }

        productRepository.saveAll(productMap.values());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productMapper.productsToProductDtos(productRepository.findAll());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product savedProduct = productRepository.save(productMapper.productDtoToProduct(productDto));
        return productMapper.productToProductDto(savedProduct);
    }

}
