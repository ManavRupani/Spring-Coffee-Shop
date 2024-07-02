package com.example.coffeshop_app.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.coffeshop_app.entity.Coffee;
import com.example.coffeshop_app.entity.Size;
import com.example.coffeshop_app.service.CoffeeService;

@Controller
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    private List<Coffee> cart = new ArrayList<>();

    @GetMapping("/coffees")
    public String getAllCoffees(Model model) {
        List<Coffee> coffees = coffeeService.getAllCoffees();
        model.addAttribute("coffees", coffees);
        return "coffees";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestBody Coffee coffee) {
        cart.add(coffee);
        return "Coffee added to cart!";
    }

    @GetMapping("/view")
    @ResponseBody
    public List<Coffee> viewCart() {
        return cart;
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    public String removeFromCart(@PathVariable Long id) {
        for (Coffee coffee : cart) {
            if (coffee.getId().equals(id)) {
                cart.remove(coffee);
                return "Coffee removed from cart!";
            }
        }
        return "Coffee not found in cart.";
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        List<String> coffeeNames = coffeeService.findAllCoffeeNames();
        Set<Size> sizes = EnumSet.allOf(Size.class);
        model.addAttribute("coffeeNames", coffeeNames);
        model.addAttribute("sizes", sizes);
        model.addAttribute("coffeeOrder", new Coffee());

        return "order";
    }

    @GetMapping("/coffeeDetails")
    @ResponseBody
    public Coffee getCoffeeDetails(@RequestParam String name, @RequestParam String size) {
        return coffeeService.findCoffeeByNameAndSize(name, Size.valueOf(size));
    }
}
