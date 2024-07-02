package com.example.coffeshop_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeshop_app.entity.Coffee;
import com.example.coffeshop_app.entity.Size;



public interface  CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee findByNameAndSize(String name, Size size);
}
