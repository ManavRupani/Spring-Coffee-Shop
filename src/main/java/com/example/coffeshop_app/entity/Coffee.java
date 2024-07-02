package com.example.coffeshop_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Size size; // Use Size enum for size attribute
    private int calories;
    private double basePrice;

    // Constructors, getters, setters, and other methods

    // Example method to calculate price based on size
    public double getPrice() {
        switch (size) {
            case S:
                return basePrice * 1.0;
            case M:
                return basePrice * 1.2;
            case L:
                return basePrice * 1.5;
            case XL:
                return basePrice * 1.8;
            default:
                return basePrice;
        }
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
