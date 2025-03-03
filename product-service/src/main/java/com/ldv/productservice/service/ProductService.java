package com.ldv.productservice.service;

import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.model.dto.ProductStockUpdateDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long id) throws ProductNotFoundException;
    List<ProductDto> getProductsByIds(List<Long> productIds);
    void updateProductStock(List<ProductStockUpdateDto> stockUpdateDtos) throws ProductNotFoundException;

}
