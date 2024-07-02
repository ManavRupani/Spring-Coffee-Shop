package com.example.coffeshop_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeshop_app.entity.Coffee;
import com.example.coffeshop_app.entity.Size;
import com.example.coffeshop_app.repository.CoffeeRepository;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<String> findAllCoffeeNames() {
        List<Coffee> allCoffees = coffeeRepository.findAll();
        return allCoffees.stream()
                         .map(Coffee::getName)
                         .distinct()
                         .collect(Collectors.toList());
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee findCoffeeByNameAndSize(String name, Size size) {
        return coffeeRepository.findByNameAndSize(name, size);
    }
}
