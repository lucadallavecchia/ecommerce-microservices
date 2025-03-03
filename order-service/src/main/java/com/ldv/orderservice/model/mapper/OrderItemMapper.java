package com.ldv.orderservice.model.mapper;

import com.ldv.orderservice.model.dto.OrderItemDto;
import com.ldv.orderservice.model.dto.ProductStockUpdateDto;
import com.ldv.orderservice.model.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);

    @Mapping(source = "quantity", target = "quantityChange", qualifiedByName = "negateQuantity")
    ProductStockUpdateDto orderItemDtoToProductStockUpdateDto(OrderItemDto orderItemDto);

    List<ProductStockUpdateDto> orderItemDtoListToProductStockUpdateDtoList(List<OrderItemDto> orderItemDtos);


    @Named("negateQuantity")
    static int negateQuantity(int quantity) {
        return -quantity;
    }
}
