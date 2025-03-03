package com.ldv.orderservice.service;

import com.ldv.orderservice.adapter.OrderAdapter;
import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;
import com.ldv.orderservice.model.dto.ProductDto;
import com.ldv.orderservice.model.entity.Order;
import com.ldv.orderservice.model.mapper.OrderMapper;
import com.ldv.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderAdapter orderAdapter;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderMapper orderMapper, final OrderAdapter orderAdapter){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
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
        return orderMapper.orderToOrderDto(orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId)));
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        /***
         * TODO:
         * OrderDto contains Quantity & priceAtOrder
         * (A)When a customer create an order we need to validate:
         * 1)"priceAtOrder": if match the priceAtOrder in the product service -> its possible having differences
         * 2)"quantity": Is it still available?
         *
         *
         * (B)How to do it?
         * 1)Call product service with a set of ids
         * 2)Validate one by one these products
         * 3)Raise a specific error in case of problem in (A.1) or (A.2)
         *
         */
        List<ProductDto> productDtos = orderAdapter.getProducts(Arrays.asList(101L,102L,103L,104L,105L));
        return null;
    }


}
