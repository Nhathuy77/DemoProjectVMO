package com.example.demoprojectmysql.service.impl;


import com.example.demoprojectmysql.model.dto.OrderCreateDTO;
import com.example.demoprojectmysql.model.entity.Account;
import com.example.demoprojectmysql.model.entity.Course;
import com.example.demoprojectmysql.model.entity.Order;
import com.example.demoprojectmysql.model.entity.OrderStatus;
import com.example.demoprojectmysql.repository.AccountRepository;
import com.example.demoprojectmysql.repository.CourseRepository;
import com.example.demoprojectmysql.repository.OrderRepository;
import com.example.demoprojectmysql.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService implements IOderService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderRepository.findAllByOrderStatus(status);
    }

    @Override
    public Order create(OrderCreateDTO dto) {
        Optional<Account> accountOptional = accountRepository.findById(dto.getAccountId());
        Optional<Course> courseOptional = courseRepository.findById(dto.getCourseId());
        if (accountOptional.isPresent() && courseOptional.isPresent()) {
            Account account = accountOptional.get();
            Course course = courseOptional.get();
            Order order = new Order();
            order.setAccount(account);
            order.setCourse(course);
            order.setQuantity(dto.getQuantity());
            order.setOrderStatus(OrderStatus.PENDING);
            return orderRepository.save(order);
        }

        return null;
    }

    @Override
    public Order buyCourse(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setOrderStatus(OrderStatus.DONE);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order cancelOrder(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setOrderStatus(OrderStatus.CANCEL);
            return orderRepository.save(order);
        }
        return null;
    }

}