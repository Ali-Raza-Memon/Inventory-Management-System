package com.inventorymanagement.system.service;

import com.inventorymanagement.system.model.Product;
import com.inventorymanagement.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    //Retreive a list of all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    //creating a new product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //Retrieve a specific product by id
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    //update a specific product by id
    public Product updateById(Product product){
        Product existingProduct = productRepository.findById(product.getProduct_id()).orElse(null);
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity_in_stock(product.getQuantity_in_stock());
        return productRepository.save(existingProduct);
    }


    //Delete a specific product by id

    public String deleteById(Long id){
        productRepository.deleteById(id);
        return "Product deleted by Id"+id;
    }





}
