package com.inventorymanagement.system.controller;

import com.inventorymanagement.system.model.Customer;
import com.inventorymanagement.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CustomerController {




    @Autowired
    private CustomerService customerService;

    //Retreive a list of all Customer
    @GetMapping("/allCustomer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }


    //creating a new product
    @PostMapping("/customer/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveProduct(customer);
    }


    //Retrieve a specific product by id
    @GetMapping("/customer/{id}")
    public Optional<Customer> getById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }


    //update a specific product by id
    @PutMapping("/product/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }




}
