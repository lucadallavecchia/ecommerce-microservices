package com.ldv.orderservice.service;

import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;

public interface OrderService {
    OrderDto getOrderById(Long orderId) throws OrderNotFoundException;

    OrderDto createOrder(OrderDto orderDto);
}
