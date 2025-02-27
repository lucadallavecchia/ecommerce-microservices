package com.ldv.orderservice.adapter;

import com.ldv.orderservice.dto.OrderDto;
import com.ldv.orderservice.mapper.OrderMapper;
import com.ldv.orderservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderAdapter {

    private final OrderMapper orderMapper;

    public OrderAdapter(final OrderMapper orderMapper){
        this.orderMapper= orderMapper;
    }

    public OrderDto toOrderDto(Order order){
            return orderMapper.orderToOrderDto(order);
    }
}
