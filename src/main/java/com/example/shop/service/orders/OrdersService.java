package com.example.shop.service.orders;

import com.example.shop.entity.Orders;

import java.util.Optional;


public interface OrdersService {

    void save(Orders order);

    Optional<Orders> findOrders(Long idUser);
}
