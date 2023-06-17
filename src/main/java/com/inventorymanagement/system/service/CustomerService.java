package com.inventorymanagement.system.service;

import com.inventorymanagement.system.model.Customer;
import com.inventorymanagement.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    //Retreive a list of all products
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }


    //creating a new product
    public Customer saveProduct(Customer customer){
        return customerRepository.save(customer);
    }

    //Retrieve a specific product by id
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    //update a specific product by id
    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.getCustomer_id()).orElse(null);
        existingCustomer.setCustomer_name(customer.getCustomer_name());
        existingCustomer.setCustomer_address(customer.getCustomer_address());
        existingCustomer.setPhone_number(customer.getPhone_number());
        existingCustomer.setEmail(customer.getEmail());

       return customerRepository.save(existingCustomer);
    }


    //Delete a specific product by id

    public String deleteById(Long id){
        customerRepository.deleteById(id);
        return "Product deleted by Id"+id;
    }





}
