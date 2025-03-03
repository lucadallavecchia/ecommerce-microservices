package com.ldv.orderservice.service;

import com.ldv.orderservice.adapter.OrderAdapter;
import com.ldv.orderservice.model.dto.OrderDto;
import com.ldv.orderservice.exception.OrderNotFoundException;
import com.ldv.orderservice.model.dto.OrderItemDto;
import com.ldv.orderservice.model.dto.ProductDto;
import com.ldv.orderservice.model.entity.Order;
import com.ldv.orderservice.model.entity.OrderItem;
import com.ldv.orderservice.model.mapper.OrderMapper;
import com.ldv.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderAdapter orderAdapter;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderMapper orderMapper, final OrderAdapter orderAdapter) {
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
    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {

        List<Long> productsIds = orderDto.getItems().stream().map(OrderItemDto::getProductId).toList();
        List<ProductDto> productsDtos = !productsIds.isEmpty() ? orderAdapter.getProducts(productsIds) : Collections.emptyList();

        if (validateOrder(orderDto.getItems(), productsDtos)) {
            //create order/orderItems in a table
            return orderMapper.orderToOrderDto(
                    orderRepository.save(
                            this.configureOrderItems(orderDto)
                    )
            );

            //update product stocks
        }
        return null;
    }

    /***
     * Validate the order:
     * -All products exists
     * -Price is not changed
     * -Availability
     *
     * @param orderItemDtos
     * @param productDtos
     * @return boolean
     */
    private boolean validateOrder(List<OrderItemDto> orderItemDtos, List<ProductDto> productDtos) {
        Map<Long, ProductDto> productMap = productDtos.stream()
                .collect(Collectors.toMap(ProductDto::getId, Function.identity()));

        return orderItemDtos.stream()
                .allMatch(orderItem -> {
                    ProductDto product = productMap.get(orderItem.getProductId());

                    return product != null // Product exists
                            && orderItem.getPriceAtOrder().compareTo(product.getPrice()) == 0 // Price matches
                            && product.getStock() >= orderItem.getQuantity(); // Stock is sufficient
                });
    }

    /***
     * Enforce the assignment of the order reference.
     * @param orderDto
     * @return Order
     */
    private Order configureOrderItems(OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
        }
        return order;
    }
}
