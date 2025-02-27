package com.ldv.orderservice.mapper;

import com.ldv.orderservice.dto.OrderDto;
import com.ldv.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    @Mapping(target = "totalPrice", expression = "java(order.getTotalPrice())")
    OrderDto orderToOrderDto(Order order);

    List<OrderDto> ordersToOrderDtos(List<Order> orders);
}
