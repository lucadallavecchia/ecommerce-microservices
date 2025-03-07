package com.ldv.orderservice.model.mapper;

import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    @Mapping(target = "totalPrice", expression = "java(order.getTotalPrice())")
    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);

}
