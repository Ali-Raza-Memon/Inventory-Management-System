package com.inventorymanagement.system.controller;

import com.inventorymanagement.system.model.Product;
import com.inventorymanagement.system.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    //Retreive a list of all products
    @GetMapping("/allProduct")
    public List<Product> getAllProducts(){
        return productService. getAllProducts();
    }


    //creating a new product
    @PostMapping("/product/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }


    //Retrieve a specific product by id
    @GetMapping("/product/{id}")
    public Optional<Product> getById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    //update a specific product by id
    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateById(product);
    }












}
