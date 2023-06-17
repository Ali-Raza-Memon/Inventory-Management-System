package com.inventorymanagement.system.controller;

import com.inventorymanagement.system.model.Customer;
import com.inventorymanagement.system.model.Order;
import com.inventorymanagement.system.service.CustomerService;
import com.inventorymanagement.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    //Retreive a list of all orders
    @GetMapping("/allOrders")
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }


    //creating a new product
    @PostMapping("/order/save")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }


    //Retrieve a specific product by id
    @GetMapping("/order/{id}")
    public Optional<Order> getById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    //update a specific product by id
    @PutMapping("/order/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }



}
