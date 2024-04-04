package com.example.demoprojectmysql.repository;

import com.example.demoprojectmysql.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
