package com.inventorymanagement.system.service;

import com.inventorymanagement.system.model.Product;
import com.inventorymanagement.system.model.Supplier;
import com.inventorymanagement.system.repository.ProductRepository;
import com.inventorymanagement.system.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    //Retreive a list of all supplier
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    //creating a new supplier
    public Supplier saveSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    //Retrieve a specific Supplier by id
    public Optional<Supplier> getSupplierById(Long id){
        return supplierRepository.findById(id);
    }

    //update a specific Supplier by id
    public Supplier updateSupplier(Supplier supplier){

        Supplier existingSupplier = supplierRepository.findById(supplier.getSupplier_id()).orElse(null);
        existingSupplier.setSupplier_name(supplier.getSupplier_name());
        existingSupplier.setContact_person(supplier.getContact_person());
        existingSupplier.setAddress(supplier.getAddress());
        existingSupplier.setPhone_number(supplier.getPhone_number());
        existingSupplier.setEmail(supplier.getEmail());

        return supplierRepository.save(existingSupplier);
    }

    //Delete a specific Supplier by id
    public String deleteById(Long id){
        supplierRepository.deleteById(id);
        return "supplier deleted by Id"+id;
    }
}
