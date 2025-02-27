package com.ldv.orderservice.mapper;

import com.ldv.orderservice.dto.OrderItemDto;
import com.ldv.orderservice.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);
}
