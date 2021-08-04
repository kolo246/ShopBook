package com.example.shop.service.orders;


import com.example.shop.entity.Orders;
import com.example.shop.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    public OrdersServiceImpl(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public OrdersServiceImpl() {
    }

    @Override
    public void save(Orders order) {
        ordersRepo.save(order);
    }

    @Override
    public Optional<Orders> findOrders(Long id) {
        return ordersRepo.findOrdersByUser_Id(id);
    }
}
