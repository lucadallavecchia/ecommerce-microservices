package com.ldv.orderservice.repository;

import com.ldv.orderservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Trova tutti gli ordini di un cliente specifico
    List<Order> findByCustomerId(Long customerId);

    // Trova tutti gli ordini con un prezzo totale superiore a un certo valore
    /*@Query("SELECT o FROM Order o WHERE o.getTotalPrice() > :price")
    List<Order> findByTotalPriceGreaterThan(@Param("price") BigDecimal price);*/
}
