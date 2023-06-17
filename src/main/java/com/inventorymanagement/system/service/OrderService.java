package com.inventorymanagement.system.service;

import com.inventorymanagement.system.model.Customer;
import com.inventorymanagement.system.model.Order;
import com.inventorymanagement.system.repository.CustomerRepository;
import com.inventorymanagement.system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    //Retreive a list of all orders
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }


    //creating a new order
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    //Retrieve a specific product by id
    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    //update a specific product by id
    public Order updateOrder(Order order){
        Order existingOrder = orderRepository.findById(order.getOrder_id()).orElse(null);
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setTotal_amount(order.getTotal_amount());

        return orderRepository.save(existingOrder);
    }

    //Delete a specific product by id
    public String deleteById(Long id){
        orderRepository.deleteById(id);
        return "order deleted by Id"+id;
    }



}
