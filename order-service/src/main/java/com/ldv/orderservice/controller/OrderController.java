package com.ldv.orderservice.controller;

import com.ldv.orderservice.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/order-service/v1/orders")
public class OrderController {

    @GetMapping
    public void getAllOrders() {
        //TODO
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderId);
        orderDto.setCustomerId(1L);
        orderDto.setTotalPrice(new BigDecimal("10"));
        return ResponseEntity.ok(orderDto);
        //TODO redefine the logic of exception
        //throw new OrderNotFoundException(orderId);
    }

}
