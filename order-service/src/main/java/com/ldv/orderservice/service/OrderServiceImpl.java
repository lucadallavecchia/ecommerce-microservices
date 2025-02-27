package com.ldv.orderservice.service;

import com.ldv.orderservice.adapter.OrderAdapter;
import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;
import com.ldv.orderservice.model.entity.Order;
import com.ldv.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderAdapter orderAdapter;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderAdapter orderAdapter){
        this.orderRepository = orderRepository;
        this.orderAdapter = orderAdapter;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return List.of();
    }

    @Override
    public List<Order> getOrdersWithTotalPriceAbove(BigDecimal price) {
        return List.of();
    }

    @Override
    public OrderDto getOrderById(Long orderId) throws OrderNotFoundException {
        return orderAdapter.toOrderDto(orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId)));
    }

}
