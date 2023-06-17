package com.inventorymanagement.system.controller;

import com.inventorymanagement.system.model.Customer;
import com.inventorymanagement.system.model.OrderItem;
import com.inventorymanagement.system.service.CustomerService;
import com.inventorymanagement.system.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class OrderItemController {


    @Autowired
    private OrderItemService orderItemService;


    //Retreive a list of all Customer
    @GetMapping("/OrderItems")
    public List<OrderItem> getAllOrderITem(){
        return orderItemService.getAllOrderITem();
    }


    //creating a new OrderItem
    @PostMapping("/orderItem/save")
    public OrderItem saveOrderITem(@RequestBody OrderItem orderItem){
        return orderItemService.saveOrderItem(orderItem);
    }


    //Retrieve a specific OrderItem by id
    @GetMapping("/orderItem/{id}")
    public Optional<OrderItem> getById(@PathVariable Long id){
        return orderItemService.getOrderItemById(id);
    }

    //update a specific OrderItem by id
    @PutMapping("/orderItem/update")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.updateOrderItem(orderItem);
    }





}
