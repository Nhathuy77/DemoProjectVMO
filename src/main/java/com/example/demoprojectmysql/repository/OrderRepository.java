package com.example.demoprojectmysql.repository;

import com.example.demoprojectmysql.model.entity.Order;
import com.example.demoprojectmysql.model.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByOrderStatus(OrderStatus orderStatus);
}
