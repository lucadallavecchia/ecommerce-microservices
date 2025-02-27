package com.ldv.orderservice.adapter;

import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.model.mapper.OrderMapper;
import com.ldv.orderservice.model.entity.Order;
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
