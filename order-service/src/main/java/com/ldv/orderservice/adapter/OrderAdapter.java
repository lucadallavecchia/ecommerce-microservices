package com.ldv.orderservice.adapter;

import com.ldv.orderservice.client.ProductProxy;
import com.ldv.orderservice.model.dto.ProductDto;
import com.ldv.orderservice.model.dto.ProductStockUpdateDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderAdapter {

    private final ProductProxy productProxy;

    public OrderAdapter(final ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    public ProductDto getProduct(Long productId) {
        return productProxy.getProductById(productId);
    }

    public List<ProductDto> getProducts(List<Long> productIds) {
        return productProxy.getProductsByIds(productIds);
    }

    public void updateProductStock(List<ProductStockUpdateDto> productStockUpdateDtos){
        productProxy.updateProductStock(productStockUpdateDtos);
    }

}
