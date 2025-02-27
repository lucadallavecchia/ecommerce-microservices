package com.ldv.orderservice.service;

import com.ldv.orderservice.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;
import com.ldv.orderservice.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomerId(Long customerId);
    List<Order> getOrdersWithTotalPriceAbove(BigDecimal price);
    OrderDto getOrderById(Long orderId) throws OrderNotFoundException;
}
