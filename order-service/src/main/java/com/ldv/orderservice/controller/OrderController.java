package com.ldv.orderservice.controller;

import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;
import com.ldv.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/order-service/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public void getAllOrders() {
        //TODO
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {

        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);

    }

}
