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


    //Retreive a list of all Order Item
    public List<OrderItem> getAllOrderITem(){
        return orderItemRepository.findAll();
    }


    //creating a new Order Item
    public OrderItem saveOrderItem(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

    //Retrieve a specific Order Item by id
    public Optional<OrderItem> getOrderItemById(Long id){
        return orderItemRepository.findById(id);
    }

    //update a specific OrderItem by id
    public OrderItem updateOrderItem(OrderItem orderItem){
        OrderItem existingOrderItem = orderItemRepository.findById(orderItem.getOrder_item_id()).orElse(null);
        existingOrderItem.setQuantity(orderItem.getQuantity());
        existingOrderItem.setUnit_price(orderItem.getUnit_price());

        return orderItemRepository.save(orderItem);
    }


    //Delete a specific Order Item by id
    public String deleteById(Long id){
        orderItemRepository.deleteById(id);
        return "Order Item deleted by Id"+id;
    }


}
