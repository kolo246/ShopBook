package com.example.shop.repository;

import com.example.shop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
    Optional<Orders> findOrdersByUser_Id(Long id);
}
