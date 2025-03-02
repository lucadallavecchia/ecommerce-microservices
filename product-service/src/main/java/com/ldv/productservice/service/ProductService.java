package com.ldv.productservice.service;

import com.ldv.productservice.exception.ProductNotFoundException;
import com.ldv.productservice.model.dto.ProductDto;

public interface ProductService {

    ProductDto getProductById(Long id) throws ProductNotFoundException;

}
