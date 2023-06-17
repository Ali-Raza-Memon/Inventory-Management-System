package com.inventorymanagement.system.controller;

import com.inventorymanagement.system.model.Product;
import com.inventorymanagement.system.model.Supplier;
import com.inventorymanagement.system.service.ProductService;
import com.inventorymanagement.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplierController {


    @Autowired
    private SupplierService supplierService;

    //Retrieve a list of all supplier
    @GetMapping("/allSupplier")
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllSuppliers();
    }


    //creating a new supplier
    @PostMapping("/supplier/save")
    public Supplier saveSupplier(@RequestBody Supplier supplier){
        return supplierService.saveSupplier(supplier);
    }


    //Retrieve a specific supplier by id
    @GetMapping("/supplier/{id}")
    public Optional<Supplier> getById(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }


    //update a specific supplier by id
    @PutMapping("/supplier/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }



}
