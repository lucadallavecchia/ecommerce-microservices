package com.ldv.productservice.model.mapper;

import com.ldv.productservice.model.dto.ProductDto;
import com.ldv.productservice.model.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productsToProductDtos(List<Product> products);

    List<Product> productDtosToProducts(List<ProductDto> productDtos);

}
