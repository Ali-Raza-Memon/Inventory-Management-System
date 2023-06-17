package com.inventorymanagement.system.service;


import com.inventorymanagement.system.model.OrderItem;
import com.inventorymanagement.system.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {


    @Autowired
    private OrderItemRepository orderItemRepository;


    //Retreive a list of all products
    public List<OrderItem> getAllOrderITem(){
        return orderItemRepository.findAll();
    }


    //creating a new product
    public OrderItem saveProduct(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

    //Retrieve a specific product by id
    public Optional<OrderItem> getOrderItemById(Long id){
        return orderItemRepository.findById(id);
    }

    //update a specific product by id
    public OrderItem updateCustomer(OrderItem orderItem){
        OrderItem existingOrderItem = orderItemRepository.findById(orderItem.getOrder_item_id()).orElse(null);
        existingOrderItem.setQuantity(orderItem.getQuantity());
        existingOrderItem.setUnit_price(orderItem.getUnit_price());

        return orderItemRepository.save(orderItem);
    }


    //Delete a specific product by id
    public String deleteById(Long id){
        orderItemRepository.deleteById(id);
        return "Product deleted by Id"+id;
    }


}
