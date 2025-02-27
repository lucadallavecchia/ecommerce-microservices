package com.ldv.orderservice.model.mapper;

import com.ldv.orderservice.model.dto.OrderItemDto;
import com.ldv.orderservice.model.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);
}
